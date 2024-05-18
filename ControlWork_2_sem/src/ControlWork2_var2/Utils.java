package ControlWork2_var2;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Utils {
    private List<BirthData> data;

    public Utils(List<BirthData> data){
        this.data = data;
    }

    //1
    public Map<String, Double> getAvgBwtByRace(){
        Map<String, List<Integer>> raceToBwt = new HashMap<>();
        for(BirthData i : data){
            if(raceToBwt.containsKey(i.getRace())){
                raceToBwt.get(i.getRace()).add(i.getBirthWeight());
            } else {
                List<Integer> tmp = new ArrayList<>();
                tmp.add(i.getBirthWeight());
                raceToBwt.put(i.getRace(), tmp);
            }
        }

        return raceToBwt.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, n -> n.getValue().stream().mapToInt(Integer::intValue).average().orElse(0)));
    }

    //2
    public boolean avgGestation(){
        Map<Boolean, List<Integer>> smokerGest = new HashMap<>();
        smokerGest.put(true, new ArrayList<>());
        smokerGest.put(false, new ArrayList<>());

        for(BirthData i : data){
            smokerGest.get(i.isSmoken()).add(i.getGestation());
        }

        return smokerGest.get(true).stream().mapToInt(Integer::intValue).average().orElse(0) <
                smokerGest.get(false).stream().mapToInt(Integer::intValue).average().orElse(0);
    }
}
