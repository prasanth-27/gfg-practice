package Feb_2026;

import java.util.HashMap;
import java.util.HashSet;

public class IsomorphicStrings {

    public static void main(String[] args) {
        String s1 = "aab";
        String s2 = "xxy";
        System.out.println(areIsomorphic(s1,s2));

        s1 = "aab";
        s2 = "xyz";
        System.out.println(areIsomorphic(s1,s2));

        s1 = "abc";
        s2 = "xxz";
        System.out.println(areIsomorphic(s1,s2));
    }

    //kind of works but not if the count of distinct is not same but length same
    //aabbcc bbccab
    public static boolean areIsomorphic(String s1, String s2){
        HashSet<Character> set1 = new HashSet<>();
        HashSet<Character> set2 = new HashSet<>();

        for(Character c: s1.toCharArray())
            set1.add(c);

        for(Character c: s2.toCharArray())
            set2.add(c);

        if(set1.size() == set2.size())
            return true;

        return false;
    }

    //abbccc aaaccb should return false as per the expectation
    public static boolean areIsomorphic2(String s1, String s2){
        HashMap<Character,Character> set1 = new HashMap<>();
        HashSet<Character> set2 = new HashSet<>();

        for(int i=0;i<s1.length();i++){
            Character c1 = s1.charAt(i);
            Character c2 = s2.charAt(i);

            if(set1.containsKey(c1)){
                //element already seen
                //check if previous and current mapping are same
                if(set1.get(c1)!=c2)
                    return false;
            }else{
                //element not seen yet
                //check if set2 already mapped
                if(set2.contains(c2))
                    //c2 already mapped to other element
                    return false;
                else {
                    //c2 and c1 both not mapped yet create mapping
                    set1.put(c1, c2);
                    set2.add(c2);
                }
            }
        }
        return true;
    }


}
