package auto.boxing;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String[] strArray = new String[10];
        int[] intArrray = new int[10];
    
        ArrayList<String> stringArrayList = new ArrayList<>();
        stringArrayList.add("Tim");
//        using wrapper classes, you can treat primitive types as reference types.
        ArrayList<Integer> intArrayList = new ArrayList<>();
        intArrayList.add(54);
        
    }
}
