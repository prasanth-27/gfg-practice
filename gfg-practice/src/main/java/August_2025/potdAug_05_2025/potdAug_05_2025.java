package August_2025.potdAug_05_2025;

public class potdAug_05_2025 {
    public static void main(String[] args) {
        String s = "Too hot to hoot";
        System.out.println(isPalindrome(s));

        s = "Abc 012..## 10cbA";
        System.out.println(isPalindrome(s));

        s = "ABC $. def01ASDF";
        System.out.println(isPalindrome(s));
    }

    private static boolean isPalindrome(String s){
        int n = s.length();
        int i =0, j=n-1;

        while(i<j){
            if(!Character.isLetterOrDigit(s.charAt(i))){
                i++;
            }else if(!Character.isLetterOrDigit(s.charAt(j))){
                j--;
            }else if(Character.toLowerCase(s.charAt(i)) == Character.toLowerCase(s.charAt(j))){
                i++;
                j--;
            }else{
                return false;
            }
        }
        return true;
    }
}
