package hw4;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class DownloadFromWeb {

    public static void main(String[] args) throws MalformedURLException {
        getVideo("https://filesamples.com/samples/video/mp4/sample_1280x720_surfing_with_audio.mp4");
    }
    public static void getVideo(String path) throws MalformedURLException {
        URL url = new URL(path);
        try(BufferedInputStream in = new BufferedInputStream(url.openStream());
            OutputStream out = new FileOutputStream("homework_2_sem/src/hw4/vid.mp4")) {
            byte[] a = in.readAllBytes();
            System.out.println(a.length);
            for(byte i : a){
                out.write(i);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
