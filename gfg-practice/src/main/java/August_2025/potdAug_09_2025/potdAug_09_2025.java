package August_2025.potdAug_09_2025;

public class potdAug_09_2025 {
    public static void main(String[] args) {
        String s = "aaaaaa";
        System.out.println(longestPeriodicPrefix(s));
    }

    private static int longestPeriodicPrefix(String s){
        int n = s.length();

        int[] z = zFunction(s);

        for(int i =n-1;i>0;i--){
            if(z[i]==n-i){
                return i;
            }
        }
        return -1;
    }

    private static int[] zFunction(String s){
        int n = s.length();
        int [] z = new int[n];

        int l=0,r=0;

        for(int i=1;i<n;i++){
            if(i<=r){
                z[i] = Math.min(z[i-l], r-i+1); // set to k or remaining pattern len
            }

            while(i+z[i] <n && s.charAt(z[i])==s.charAt(z[i]+i)){
                z[i]++;
            }

            if(i+z[i]-1 > n){
                l=i;
                r=i+z[i]-1;
            }

        }

        return z;
    }
}
