package August_2025.potdAug_02_2025;

import java.util.HashMap;

public class potdJuly_2_2025 {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 1};
        int k =2;

        System.out.println(maxLenMajority(arr,k));
    }

    private static int maxLenMajority(int[] arr, int k){
        int n=arr.length;
        HashMap<Integer,Integer> mp = new HashMap<>();
        int sum=0, ans=0;

        for(int i=0;i<n;i++){
            if(arr[i]<=k) sum--;
            else sum++;

            System.out.println(i + ": "+ sum);
            if(sum>0) ans= i+1;
            else{
                if(mp.containsKey(sum-1)){
                    ans = Math.max(ans, i-mp.get(sum-1));
                }
            }
            System.out.println(ans);

            if(!mp.containsKey(sum)){
                mp.put(sum, i);
            }
        }

        return ans;

    }
}
