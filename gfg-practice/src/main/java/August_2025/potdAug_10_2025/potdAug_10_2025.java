package August_2025.potdAug_10_2025;

public class potdAug_10_2025 {
    public static void main(String[] args) {
        String s = "abaab";
        System.out.println(countPalindromeSubstrings(s));
    }

    //Another approach possible: Manacher's Algorithm

    //brute approach
    private static int countPalindromeSubstrings(String s){
        int n = s.length();
        int count=0;
        int left,right;
        for(int i =0;i<n;i++){
            //for odd size palindrome strings expand from center at i and compare left and right elements
            left=i-1;
            right=i+1;
            while(left>=0 && right<n){
                if(s.charAt(left) == s.charAt(right)){
                    count++;
                }else{
                    break;
                }
                right++;
                left--;
            }


            }

            for(int i =0;i<n;i++){
                //for even sized strings center at i
                left =i;
                right=i+1;
                while(left>=0 && right<n){
                    if(s.charAt(left) == s.charAt(right)){
                        count++;
                    }else{
                        break;
                    }
                    left--;
                    right++;
            }


        }

        return count;
    }
}
