package Feb_2026;

import java.util.HashMap;

public class Potd_Feb_24 {
    public static void main(String[] args) {
        int[] a1 = {0, 1, 0, 0, 0, 0};
        int[] a2 = {1, 0, 1, 0, 0, 1};
        System.out.println(equalSumSpan(a1, a2));
    }

    public static int equalSumSpan(int[] a1, int[] a2) {
        // code here
        int ans=0;

        int p1 = 0;
        int p2 = 0;

        HashMap<Integer,Integer> diffMap = new HashMap<>();

        for(int i=0;i<a1.length;i++){
            p1+=a1[i];
            p2+=a2[i];

            if(p1==p2)
                ans=Math.max(i+1,ans);
            else if (diffMap.containsKey(p2-p1))
                ans=Math.max(ans,
                        i-diffMap.get(p2-p1));
            else
                diffMap.put(p2-p1, i);
        }

        return ans;
    }
}
