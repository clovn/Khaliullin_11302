package hw5;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner in = new Scanner(System.in);
        FileDownloader downloader = new FileDownloader(8);

        while (true){
            String[] command = in.nextLine().split(" ");
            if(command[0].equals("download")){
                downloader.addToQueue(command[1], command[2]);
            } else if (command[0].equals("status")){
                if(!Files.exists(Path.of(command[1]))) System.out.println("0%");
                else System.out.println(downloader.status(command[1]) + "%");
            } else {
                System.out.println("command is not exist");
            }
        }
    }
}
