package August_2025.potdAug_26_2025;

public class potdAug_26_2025 {
    public static void main(String[] args) {
        String s1 = "AXY", s2 = "YADXCP";
        System.out.println(isSubSeq(s1,s2));
    }

    private static boolean isSubSeq(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        if(n==0) return true;
        if(m==0) return false;

        int i=0,j=0;
        while(i<n && j<m){
            if(s1.charAt(i) == s2.charAt(j)){
                i++;
            }
            j++;
        }

        return i==n;
    }
}
