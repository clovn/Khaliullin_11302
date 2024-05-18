package hw3;

import java.util.List;

public class IntStream extends Stream<Integer> {

    public IntStream(List<Integer> arr){
        super(arr);
    }

    public int sum(){
        int res = 0;
        for(int i : elements){
            res += i;
        }
        return res;
    }

    public int max(){
        int max = Integer.MIN_VALUE;
        for(int i : elements){
            max = Math.max(i, max);
        }
        return max;
    }

    public int min(){
        int min = Integer.MAX_VALUE;
        for(int i : elements){
            min = Math.min(i, min);
        }
        return min;
    }

    public double avg(){
        return (double) this.sum() / elements.size();
    }
}
