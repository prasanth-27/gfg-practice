package March_2026;

import java.util.HashMap;
import java.util.HashSet;

public class PythagoreanTriplet {
    public static void main(String[] args) {
        int[] arr = {3, 1, 4, 6, 5};
        System.out.println(pythagoreanTriplet(arr));
    }

    private static boolean pythagoreanTriplet(int[] arr){

        if(arr.length<3)
            return false;

        HashSet<Integer> mp = new HashSet<>();
        int max = 0;
        for(int ele: arr) {
            mp.add(ele);
            max=Math.max(ele, max);
        }

        for(int i=1;i<max+1;i++){
            if(!mp.contains(i))
                continue;

            for(int j=i+1;j<max+1;j++){

                if(!mp.contains(j))
                    continue;

                int c = (int)Math.sqrt(i*i + j*j);

                if((c*c != i*i + j*j ) || c>max)
                    continue;

                if(mp.contains(c))
                    return true;

            }
        }

        return false;
    }
}
