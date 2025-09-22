package September_2025.potdSept_11_2025;

import java.util.Arrays;

public class potdSept_11_2025 {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
        System.out.println(minJumpsOptimum(arr));
        System.out.println(minJumpsTD(arr));
        System.out.println(minJumpsBU(arr));
    }

    private static int minJumpsOptimum(int[] arr){
        if(arr[0]==0) return -1;

        int jumps=0;
        int maxReach=0,currentEnd=0;

        for(int i=0;i<arr.length;i++){

            maxReach = Math.max(maxReach, i+arr[i]);

            if(maxReach>=arr.length-1) return jumps+1;

            //check if index has reached the end of the window
            if(i==currentEnd){

                //if at end of window and equal to max reach at this point we cannot reach the end of arr
                if(i==maxReach){return -1;}
                // if at end of window then increment jump and set end of window to maxReach
                else{
                    jumps++;
                    currentEnd = maxReach;
                }

            }

        }

        return -1;
    }

    private static int minJumpsTD(int[] arr){
        int n = arr.length;
        int[] memo = new int[n];
        Arrays.fill(memo,-1);

        int ans = minTDjumps(0, arr, memo);

        return ans==Integer.MAX_VALUE?-1:ans;
    }

    private static int minTDjumps(int idx, int[] arr, int[] memo){
        if(idx == arr.length-1) return 0;

        if(memo[idx] != -1 ) return memo[idx];

        int ans = Integer.MAX_VALUE;
        for(int i = idx+1; i<=idx+arr[idx] && i < arr.length;i++){
            int jumps = minTDjumps(i , arr, memo);
            if(jumps!=Integer.MAX_VALUE){
                ans = Math.min(ans,jumps+1);
            }
        }
        memo[idx] = ans;
        return ans;
    }

    private static int minJumpsBU(int[] arr){
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[n-1] = 0;

        for(int i=n-2;i>=0;i--){
            for(int j=i+1;j<=i+arr[i] && j<n;j++){
                if(dp[j]!=Integer.MAX_VALUE){
                    dp[i] = Math.min(dp[i], dp[j]+1);
                }
            }
        }

        return dp[0]==Integer.MAX_VALUE?-1:dp[0];
    }
}
