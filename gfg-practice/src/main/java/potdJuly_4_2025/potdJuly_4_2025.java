package potdJuly_4_2025;

import java.util.LinkedHashMap;

public class potdJuly_4_2025 {

    public static void main(String[] args) {

        int[] arr = new int[]{1, 2, 2, 3};
        int k = 2;
        System.out.println(substrCnt(arr,k));

        arr = new int[]{1, 1, 1};
        k = 1;
        System.out.println(substrCnt(arr,k));

        arr = new int[]{1, 2, 1,1,3,3,4,2,1};
        k = 2;
        System.out.println(substrCnt(arr,k));
    }

    private static int substrCnt(int[]arr,int k){
        int n = arr.length;
        int i=0,j=0,result=0;
        LinkedHashMap<Integer, Integer> mp = new LinkedHashMap<>();

        while(j<n){

            //insert the element and increment the count
            mp.put(arr[j], mp.getOrDefault(arr[j],0)+1);

            //check if size of distinct elements is >k
            //if yes we move i to shrink window
            while(mp.size()>k){
                mp.put(arr[i], mp.get(arr[i])-1);
                if(mp.get(arr[i])==0){
                    mp.remove(arr[i]);
                }
                i++;
            }

            //No of substrings possible with size s
            // = no substrins of size s-1 + s
            result+=j-i+1;

            //expand window
            j++;

        }
        return result;
    }
}
