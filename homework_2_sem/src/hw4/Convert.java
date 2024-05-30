package hw4;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Convert {
    public static void main(String[] args) {

        try(FileInputStream in = new FileInputStream("homework_2_sem/src/hw4/in.txt");
            FileOutputStream out = new FileOutputStream("homework_2_sem/src/hw4/out.txt")) {

            byte[] utf8Bytes = in.readAllBytes();
            String utf8String = new String(utf8Bytes);

            byte[] windows1251Bytes = utf8String.getBytes("Windows-1251");

            out.write(windows1251Bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
