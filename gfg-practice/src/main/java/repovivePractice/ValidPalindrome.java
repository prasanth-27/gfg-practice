package repovivePractice;

import java.util.Arrays;

public class ValidPalindrome {

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));

        s = "race a car";
        System.out.println(isPalindrome(s));

        s = " ";
        System.out.println(isPalindrome(s));
    }

    private static boolean isPalindrome(String s){

        s = s.replaceAll("[^a-zA-Z]", "").toLowerCase();

        int i=0,j=s.length()-1;

        while(i<=j){

            if(s.charAt(i) != s.charAt(j))
                return false;

            i++;
            j--;

        }

        return true;
    }
}
