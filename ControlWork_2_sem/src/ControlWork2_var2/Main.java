package ControlWork2_var2;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<BirthData> data = new ArrayList<>();

        //0
        try(Scanner in = new Scanner(new FileReader("ControlWork_2_sem/src/ControlWork2_var2/BirthsKingCounty2001.txt"))){
            while (in.hasNextLine()){
                String[] tmp = in.nextLine().split("\\s+");
                data.add(new BirthData(tmp[3], Integer.parseInt(tmp[6]), tmp[11].equals("Y"), Integer.parseInt(tmp[16]), Byte.parseByte(tmp[15])));
            }
        } catch (IOException e){
            System.out.println(e.getMessage());
        }

        Utils util = new Utils(data);

        //1
        System.out.println("1.");
        util.getAvgBwtByRace().forEach((key, value) -> System.out.println(key + " - " + Math.round(value)));

        //2
        System.out.println("2." + util.avgGestation());

        //3
        generateDataset(data, "out.bin");
        showDataset("ControlWork_2_sem/src/ControlWork2_var2/out.bin");

    }

    //3
    public static void generateDataset(List<BirthData> data, String filename){
        try(OutputStream out = new FileOutputStream("ControlWork_2_sem/src/ControlWork2_var2/" + filename)){
            for(BirthData i : data){
                for(char c : i.getRace().toCharArray()){
                    out.write(c);
                }
                out.write(i.getEducation());
            }
            System.out.println("3.generated file " + filename);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void showDataset(String path){
        try(InputStream in = new FileInputStream(path)){
            StringBuilder race = new StringBuilder();
            while(in.available() > 0){
                int i = in.read();
                if(i < 90){
                    System.out.println(race + " " + i);
                    race = new StringBuilder();
                    continue;
                }
                race.append((char) i);
            }
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
