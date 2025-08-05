package July_2025.potdJuly_14_2025;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class potdJuly_14_2025 {

    public static void main(String[] args) {
        minCutsofBinaryString("1111101");
    }

    //return minimum substrings that can be formed that are powers of 5
    private static int minCutsofBinaryString(String s){
        int n = s.length();
        if('0' == s.charAt(0) || '0' == s.charAt(n-1)){
            return -1;
        }

        int maxi = n+1;
        Set<Integer> powersof5 = new HashSet<>();
        powersof5.add(1);
        int base=5;
        String basestr = Integer.toBinaryString(base);
        while(basestr.length()<=30){
            //System.out.println(base);
            //System.out.println(basestr);
            powersof5.add(base);
            base*=5;
            basestr = Integer.toBinaryString(base);
        }

        //System.out.println(powersof5.size());

        int[] dp = new int[n+1];
        Arrays.fill(dp, maxi);
         dp[n]=0;

         for(int i =n-1;i>=0;i--){
             if('0' == s.charAt(i)){
                 System.out.println("-----------");
                 continue;
             }

             int num =0;
             for(int j=i;j<n;j++){
                 num = num*2 + ('1' == s.charAt(j)?1:0);

                 if(powersof5.contains(num)){
                     if(dp[j+1] !=maxi){
                         dp[i] = Math.min(dp[i], 1+dp[j+1]);
                         System.out.println(Arrays.toString(dp));
                     }
                 }

             }
             System.out.println(Arrays.toString(dp));
             System.out.println("=========================");
         }

         return (dp[0] >=maxi) ? -1 : dp[0];
    }
}
