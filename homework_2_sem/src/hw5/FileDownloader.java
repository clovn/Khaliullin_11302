package hw5;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicBoolean;

public class FileDownloader {
    private BlockingDeque<Task> tasks;

    private Worker[] threads;
    private AtomicBoolean isShutdown;
    private ConcurrentMap<Task, Integer> tasksInProcess = new ConcurrentHashMap<>();

    public FileDownloader(int count){
        threads = new Worker[count];
        tasks = new LinkedBlockingDeque<>();
        isShutdown = new AtomicBoolean(false);

        for (int i = 0; i < count; i++){
            threads[i] = new Worker();
            threads[i].start();
        }
    }

    public void addToQueue(String url, String path) throws InterruptedException {
        if(isShutdown.get()) {
            System.out.println("Service is shutdown");
            return;
        }
        tasks.put(new Task(url, path));
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

    public int status(String path){
        try{
            return tasksInProcess.get(new Task(path));
        } catch (Exception e){
            throw new RuntimeException("task not in process");
        }
    }

    private class Worker extends Thread{
        @Override
        public void run() {
            while(!isShutdown.get() || !tasks.isEmpty()){
                Task task;

                try {
                    task = tasks.take();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                tasksInProcess.put(task, 0);

                try(BufferedInputStream in = new BufferedInputStream(new URL(task.url).openStream());
                    OutputStream out = new FileOutputStream(task.path)) {

                    byte[] arr = in.readAllBytes();
                    long countOfBytes = arr.length;
                    long count = 0;

                    for (byte i : arr){
                        count++;
                        out.write(i);
                        //System.out.println((count*100)/countOfBytes);
                        if(count % 100 == 0){
                            tasksInProcess.replace(task, (int) ((count*100)/countOfBytes));
                        }
                    }

                    tasksInProcess.replace(task, 100);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

        }
    }

    private class Task{
        String url;
        String path;

        public Task(String url, String path){
            this.url = url;
            this.path = path;
        }

        public Task(String path){
            this.path = path;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Task task = (Task) o;
            return Objects.equals(path, task.path);
        }

        @Override
        public int hashCode() {
            return Objects.hash(path);
        }
    }


}
