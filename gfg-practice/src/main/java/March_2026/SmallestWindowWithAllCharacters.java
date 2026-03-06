package March_2026;

import java.util.HashMap;

public class SmallestWindowWithAllCharacters {

    public static void main(String[] args) {

        String s = "timetopractice";
        String p = "toc";

        //String s = "timetopractice";
        //String p = "abcd";

        //String s ="uvuuuvv";
        //String p="uuvu";

        String res = minWindow(s, p);
        System.out.println(res);


    }

    private static String minWindow(String s, String p){
        String ans=s+s;

        HashMap<Character, Integer> mp = new HashMap<>();

        for(char ch : p.toCharArray())
            mp.put(ch,mp.getOrDefault(ch,0)+1);
        int count = mp.size();
        int i=0,j=0;
        System.out.println("iteration: "+i);
        while(j < s.length()){
            char ch = s.charAt(j);
            System.out.println("ch: "+ch);
            //found char ch in s
            if(mp.containsKey(ch)) {
                if (mp.get(ch) - 1 == 0)
                    count--;

                mp.put(ch, mp.get(ch) - 1);
            }

            System.out.println("count: " + count);
            //when found all chars, set the ans as candidate if smaller
            if(count==0) {
                String candidate = s.substring(i, j + 1);
                ans = (candidate.length() < ans.length()) ? candidate : ans ;
            }
            System.out.println("answer: " + ans);

            while(count<=0 && i<j){
                char c = s.charAt(i);

                //key in map update count and map
                if(mp.containsKey(c)){
                    if(mp.get(c)==0)
                        count++;
                    mp.put(c, mp.get(c)+1);
                }

                i++;

                if(count==0) {
                    String candidate = s.substring(i, j + 1);
                    ans = (candidate.length() < ans.length()) ? candidate : ans ;
                }
            }
            System.out.println("cout: " + count);
            j++;
        }

        return ans.length()>s.length() ? "" : ans;
    }
}
