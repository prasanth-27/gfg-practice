package July_2025.potdJuly_31_2025;

import java.util.ArrayList;
import java.util.HashMap;

//Given an array or string of 1,0 count no of substrings with equal 1,0
public class Practice_balancedSubString {
    public static void main(String[] args) {
        String s = "1001011";
        System.out.println(countBalancedSubStrings(s));

        System.out.println(lengthMaxBalanceString(s));
        System.out.println(listBalanceString(s));
    }

    private static int countBalancedSubStrings(String s){
        int n = s.length();

        HashMap<Integer,Integer> mp = new HashMap<>();
        mp.put(0,1); // base case sum=0 should count 1
        int sum=0;
        int count=0;
        for(int i=0;i<n;i++){
            sum+=(s.charAt(i)=='1' ? 1 : -1);

            count+=mp.getOrDefault(sum,0);

            mp.put(sum,mp.getOrDefault(sum,0)+1);
        }

        return count;
    }

    private static int lengthMaxBalanceString(String s){
        int n = s.length();
        HashMap<Integer,Integer> mp = new HashMap<>();

        int maxLen=0;
        int sum=0;

        for(int i=0;i<n;i++){
            sum+=(s.charAt(i)=='1'?1:-1);

            if(sum==0){
                maxLen=Math.max(maxLen, i+1);
            }

            if(mp.containsKey(sum)){
                System.out.println(i+"--"+mp.get(sum));

                // not i-mp.get(sum) as the substring starts from mp.get(sum)+1 and ends at i
                // so size of subString will be 1 less than the actual size diff i.e i-mp.get(sum)+1
                maxLen = Math.max(maxLen, i-mp.get(sum));
            }else{
                mp.put(sum,i);
            }

        }

        return maxLen;
    }

    private static ArrayList<String> listBalanceString(String s){
        int n = s.length();
        HashMap<Integer,ArrayList<Integer>> mp = new HashMap<>();
        ArrayList<String> res = new ArrayList<>();
        int sum=0;

        for(int i=0;i<n;i++){
            sum+=(s.charAt(i)=='1'?1:-1);

            if(sum==0){
                res.add(s.substring(0,i+1));
            }

            if(mp.containsKey(sum)){
                ArrayList<Integer> l = mp.get(sum);
                for(int idx : l){
                    res.add(s.substring(idx+1,i+1));
                }
                l.add(i);
                mp.put(sum,l);
            }else{
                ArrayList<Integer> l = new ArrayList<>();
                l.add(i);
                mp.put(sum,l);
            }
        }

        return res;
    }

}
