package hw6;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {

    private final static String API_KEY = "b1463022a053f30a833a84f4f8f78cd9";

    public static void main(String[] args) throws MalformedURLException {
        try(FileWriter out = new FileWriter("homework_2_sem/src/hw6/weather.csv");
            Scanner in = new Scanner(System.in)){
            for(String i : in.nextLine().split(" ")){
                out.write(getWeather(i) + "\n");
            }

        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    public static String getWeather(String city) throws MalformedURLException {
        URL url = new URL("https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + API_KEY + "&units=metric");
        String res = "";
        try(Scanner in = new Scanner(url.openStream())){
            String input = in.nextLine();
            Map<String, Object> a = parseJSON(input);
            Map<String, Object> main = (Map<String, Object>) a.get("main");
            LocalDateTime date = LocalDateTime.now();
            DateTimeFormatter pattern = DateTimeFormatter.ofPattern("dd.MM.yy");
            res = city + ";" + main.get("temp") + ";" + pattern.format(date);

        } catch (IOException e){
            System.out.println(e.getMessage());
        }

        return res;
    }

    private static Map<String, Object> parseJSON(String json){
        Map<String, Object> data = new HashMap<>();
        json = json.replace("[", "").replace("]", "").replace("\"", "");
        json = json.substring(1, json.length() - 1);
        StringBuilder key = new StringBuilder();
        StringBuilder value = new StringBuilder();
        int state = 0;
        for(char i : json.toCharArray()){
            if (state == 0){
                if(i == ',') continue;
                if(i == ':'){
                    state = 1;
                } else {
                    key.append(i);
                }
            }
            else if(state == 1){
                if(i == '{'){
                    state = 3;
                } else {
                    state = 2;
                }
                value.append(i);
            }
            else if (state == 2){
                if(i == ','){
                    data.put(key.toString(), value.toString());
                    key = new StringBuilder();
                    value = new StringBuilder();
                    state = 0;
                } else {
                    value.append(i);
                }
            }
            else if (state == 3){
                if(i == '}'){
                    data.put(key.toString(), parseJSON(value + "}"));
                    key = new StringBuilder();
                    value = new StringBuilder();
                    state = 0;
                } else {
                    value.append(i);
                }
            }
        }
        data.put(key.toString(), value.toString());

        return data;
    }
}
