package potdJuly_19_2025;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.IntStream;

public class potdJuly_19_2025 {

    public static void main(String[] args) {
        String s = "aeiou";
        System.out.println(countVowels(s));

        s = "aae";
        System.out.println(countVowels(s));

        s = "aaeei";
        System.out.println(countVowels(s));
    }

    private static int countVowels(String s){
        int n = s.length();

        int ans=1;

        List<Character> ch = List.of('a','e','i','o','u');

        HashMap<Character,Integer> vowelcount = new HashMap<>();

        for(int i = 0;i<n;i++){
            char c = s.charAt(i);
            if(ch.contains(c)) {
                vowelcount.put(s.charAt(i), vowelcount.getOrDefault(s.charAt(i), 0) + 1);
            }
        }

        if(vowelcount.size()==0){
            return 0;
        }

        for(Character c : vowelcount.keySet()){
            ans*=vowelcount.get(c);
        }

        ans*=IntStream.rangeClosed(1,vowelcount.size()).reduce(1,(a,b)->a*b);

        return ans;
    }
}
