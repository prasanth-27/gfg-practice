package July_2025.potdJuly_3_2025;

public class LongestSubstring {

    public static void main(String[] args) {

        String s ="aabacbebebe";
        int k=3;
        System.out.println(longestSubstring(s,k));

        s="aaaa";
        k=2;
        System.out.println(longestSubstring(s,k));

        s="aabaaab";
        k=2;
        System.out.println(longestSubstring(s,k));

        s="a";
        k=2;
        System.out.println(longestSubstring(s,k));

    }

    private static int longestSubstring(String s,int k){

        int n = s.length();

        if(k>n){
            return -1;
        }

        int result=-1;
        int distinct = 0,i=0,j=0;
        int size=0;

        int[] mp = new int[26];

        while(j<n){

            size=j-i+1;
            int jcount=mp[s.charAt(j)-'a'];
            if(jcount==0){
                distinct++;
            }
            mp[s.charAt(j)-'a']=jcount+1;

            if(distinct==k && size>result){
                result = size;
            }

            while(distinct>k){
                int icount = mp[s.charAt(i)-'a'];
                icount--;
                if(icount==0){
                    distinct--;
                }
                mp[s.charAt(i)-'a']=icount;
                i++;
            }

            j++;
        }

        return result;
    }
}
