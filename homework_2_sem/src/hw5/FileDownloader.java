package hw5;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicBoolean;

public class FileDownloader {
    private BlockingDeque<String> tasks;

    private Worker[] threads;
    private AtomicBoolean isShutdown;
    private ConcurrentMap<String, Integer> tasksInProcess = new ConcurrentHashMap<>();

    public FileDownloader(int count){
        threads = new Worker[count];
        tasks = new LinkedBlockingDeque<>();
        isShutdown = new AtomicBoolean(false);

        for (int i = 0; i < count; i++){
            threads[i] = new Worker();
            threads[i].start();
        }
    }

    public void addToQueue(String url) throws InterruptedException {
        if(isShutdown.get()) {
            System.out.println("Service is shutdown");
            return;
        }
        tasks.put(url);
    }

    public void shutdown(){
        isShutdown.set(true);
    }

    public void shutdownNow(){
        isShutdown.set(true);
        for (Thread worker : threads) {
            worker.interrupt();
        }
    }

    public int status(String filename){
        try{
            return tasksInProcess.get(filename);
        } catch (Exception e){
            throw new RuntimeException("task not in process");
        }
    }

    private class Worker extends Thread{
        @Override
        public void run() {
            while(!isShutdown.get() || !tasks.isEmpty()){
                String url;
                String fileName;

                try {
                    url = tasks.take();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                String[] tmp = url.split("/");
                fileName = tmp[tmp.length - 1];

                tasksInProcess.put(fileName, 0);

                try(BufferedInputStream in = new BufferedInputStream(new URL(url).openStream());
                    OutputStream out = new FileOutputStream("homework_2_sem/src/hw5/files/" + fileName)) {

                    int countOfBytes = in.available();
                    int count = 0;

                    for (byte i : in.readAllBytes()){
                        count++;
                        out.write(i);
                        if(count % 100 == 0){
                            tasksInProcess.replace(fileName, (count*100)/countOfBytes);
                        }
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

        }
    }


}
