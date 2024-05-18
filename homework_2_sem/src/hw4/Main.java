package hw4;

import java.io.BufferedOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        DOMTree a = new DOMTree("http://127.0.0.1:5000/");
        a.generateHtml();
        try(FileWriter out = new FileWriter("homework_2_sem/src/hw4/text.txt")){
            out.write(a.getText());
        } catch (IOException e){
            System.out.println(e.getMessage());
        }

    }
}
