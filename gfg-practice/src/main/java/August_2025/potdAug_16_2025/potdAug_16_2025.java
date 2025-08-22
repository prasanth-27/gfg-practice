package August_2025.potdAug_16_2025;

import java.util.ArrayList;
import java.util.Collections;

public class potdAug_16_2025 {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 30, 34, 5, 9};
        System.out.println(largestNum(arr));
    }

    private static String largestNum(int[] arr){
        int n = arr.length;

        ArrayList<String> sArr = new ArrayList<>();

        for(int i=0;i<n;i++){
            sArr.add(String.valueOf(arr[i]));
        }

        Collections.sort(sArr, (e1, e2)->{
          return ((e2+e1).compareTo(e1+e2));
        }
        );

        if(sArr.get(0).contentEquals("0")){
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for(String ele: sArr){
            sb.append(ele);
        }

        return sb.toString();

    }
}
