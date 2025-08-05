package July_2025.potdJuly_29_2025;

import java.util.*;

public class potdJuly_29_2025 {

    public static void main(String[] args) {
        String s = "abacab";
        System.out.println(asciiSum(s));

        s = "acdac";
        System.out.println(asciiSum(s));

    }

    private static ArrayList<Integer> asciiSum(String s){
        int n = s.length();

        HashMap<Character, ArrayList<Integer>> eleList = new HashMap<>();

        ArrayList<Integer> res = new ArrayList<>();

        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            ArrayList<Integer> l = eleList.getOrDefault(ch, new ArrayList<>());
            if(l.size()<2){
                l.add(i);
            }else{
                l.removeLast();
                l.addLast(i);
            }
            eleList.put(ch,l);
        }

        System.out.println(eleList);

        for(char ch : eleList.keySet()){
            if(eleList.get(ch).size()==2){
                int sum=0;
                for(int i = eleList.get(ch).get(0)+1; i<eleList.get(ch).get(1);i++){
                    sum+=s.charAt(i);
                }
                System.out.println(sum);
                System.out.println("========================");
                if(sum>0) res.add(sum);
            }
        }

        return res;
    }
}
