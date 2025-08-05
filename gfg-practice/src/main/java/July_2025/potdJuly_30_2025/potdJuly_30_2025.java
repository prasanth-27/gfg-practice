package July_2025.potdJuly_30_2025;

import java.util.HashMap;

public class potdJuly_30_2025 {

    public static void main(String[] args) {
        int[] arr = new int[]{10, 2, -2, -20, 10};
        int k =-10;
        System.out.println(countSubarrays(arr,k));

        //9, 4, 20, 3, 10, 5
        arr = new int[]{9, 4, 20, 3, 10, 5};
        k =33;
        System.out.println(countSubarrays(arr,k));

        arr = new int[]{1,3,5};
        k =0;
        System.out.println(countSubarrays(arr,k));
    }

    private static int countSubarrays(int[] arr, int k){
        int n = arr.length;

        HashMap<Integer,Integer> prefixSums = new HashMap<>();

        int currSum=0;
        int res=0;
        for(int i=0;i<n;i++){

            currSum+=arr[i];

            if(currSum-k ==0){
                res++;
            }
            if(prefixSums.containsKey(currSum-k)){
                res+=prefixSums.get(currSum-k);
            }

            prefixSums.put(currSum, prefixSums.getOrDefault(currSum,0)+1);
        }

        return res;
    }
}
