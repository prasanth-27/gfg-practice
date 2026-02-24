package repovivePractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] strings = new String[]{"eat","tea","tan","ate","nat","bat"};
        System.out.println(group(strings));
    }

    public static ArrayList<ArrayList<String>> group(String[] strings){

        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        HashMap<String,ArrayList<String>> mp = new HashMap<>();

        for(String s: strings){
            char[] c = s.toCharArray();
            Arrays.sort(c);

            //.toString will return object.toString which will be the objectid .valueOf returns the string of contents of c[]
            String key = String.valueOf(c);

            ArrayList<String> list = mp.getOrDefault(key, new ArrayList<>());
            list.add(s);
            mp.put(key,list);

        }

        for(String key : mp.keySet()){
            ans.add(mp.get(key));
        }
        return ans;
    }
}
