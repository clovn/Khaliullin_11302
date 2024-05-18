package hw4;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class DownloadFromWeb {

    public static void main(String[] args) throws MalformedURLException {
        getVideo("https://www.youtube.com/watch?v=dQw4w9WgXcQ&ab_channel=RickAstley");
    }
    public static void getVideo(String path) throws MalformedURLException {
        URL url = new URL(path);
        try(BufferedInputStream in = new BufferedInputStream(url.openStream());
            OutputStream out = new FileOutputStream("homework_2_sem/src/hw4/vid.mp4")) {
            for (byte i : in.readAllBytes()){
                out.write(i);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
