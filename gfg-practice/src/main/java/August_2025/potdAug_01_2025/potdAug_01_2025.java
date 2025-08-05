package August_2025.potdAug_01_2025;

import java.util.HashMap;

public class potdAug_01_2025 {

    public static void main(String[] args) {
        String[] arr = new String[]{"aeio", "aa", "bc", "ot", "cdbd"};
        System.out.println(countBalancedStrings(arr));

        arr = new String[]{"ab", "be"};
        System.out.println(countBalancedStrings(arr));
    }

    private static int countBalancedStrings(String[] arr){
        int n = arr.length;

        HashMap<Integer,Integer> mp = new HashMap<>();
        mp.put(0,1);
        int count=0;
        int sum=0;
        for(int i =0;i<n;i++){
            String s = arr[i];
            for(char ch : s.toCharArray()){
                if(isVowel(ch)){
                    sum++;
                }
                else{
                    sum--;
                }
            }

            if(mp.containsKey(sum)){
                count+=mp.get(sum);
            }

            mp.put(sum, mp.getOrDefault(sum,0)+1);
        }

        return count;
    }

    private static boolean isVowel(char ch) {
        if('a'==ch || 'e'==ch || 'i'==ch || 'o'==ch || 'u'==ch){
            return true;
        }

        return false;
    }
}
