package potdJuly_1_2025;

import java.util.Arrays;

public class SubstrCnt {

    public static void main(String[] args) {
        String s="abcc";
        System.out.println("bruteforce: "+substrCountBruteForce(s,2));
        System.out.println("SlidingWindow: "+substrCountSlidingWindow(s,2));

        s="aabab";
        System.out.println("bruteforce: "+substrCountBruteForce(s,3));
        System.out.println("SlidingWindow: "+substrCountSlidingWindow(s,3));
    }

    public static int substrCountBruteForce(String s, int k) {
        long n = s.length();
        char[] S = s.toCharArray();
        int result=0;
        int req=k-1;

        for(int i=0;i<=n-k;i++){
            int[] mp = new int[26];
            int distinct=0;
            for(int j=i;j<i+k;j++){
                System.out.println(S[j]);
                System.out.println(mp[S[j]-'a']);
                int count=mp[S[j]-'a'];
                if(count==0){
                    distinct++;
                }
                mp[S[j]-'a']= count+1;
            }
            System.out.println(Arrays.toString(mp));
            System.out.println(distinct);
            if(distinct == k-1){
                result++;
            }
        }
        return result;
    }

    public static int substrCountSlidingWindow(String s, int k) {
        long n = s.length();
        char[] S = s.toCharArray();
        int result=0,distinct=0;
        int[] mp = new int[26];
        int i=0,j=0;
        while(j<n){

            int jcount = mp[S[j]-'a'];
            if(jcount==0){
                distinct++;
            }
            mp[S[j]-'a']=jcount+1;

            //check if window size >k
            while(j-i+1 >k){
                int charCount = mp[S[i]-'a'];
                if(charCount-1==0){
                    distinct--;
                }
                mp[S[i]-'a']=charCount-1;
                i++;
            }

            if(j-i+1 == k){
                if(distinct==k-1){
                    result++;
                }
            }

            j++;
        }

        return result;
    }

}
