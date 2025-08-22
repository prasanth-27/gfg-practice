package August_2025.potdAug_13_2025;

import java.util.ArrayList;
import java.util.Arrays;

public class potdAug_13_2025 {
    public static void main(String[] args) {
        int[] arr = new int[]{5, 6, 3, 2, 1};
        int k =2;
        System.out.println(minCostLucky(arr,k));
    }

    private static int minCostLucky(int[] arr, int k){
        int n = arr.length;
        int ans=0;
        int[] costs= new int[n];
        int need = (n+1)/2;


        for(int i=0;i<n;i++){

            if(arr[i]%k==0) costs[i]=0;
            else costs[i] = (k-(arr[i]%k));
        }
        //System.out.println(Arrays.toString(costs));
        Arrays.sort(costs);
        //System.out.println(need);
        //System.out.println(Arrays.toString(costs));
        for(int i =0;i<need;i++){
            ans+=costs[i];
        }

        return ans;
    }
}
