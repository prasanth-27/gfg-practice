package July_2025.potdJuly_20_2025;

import java.util.Arrays;

public class potdJuly_20_2025 {

    public static void main(String[] args) {


        int n=4;
        int[] arr = new int[]{0,2,4,7};
        System.out.println(countValid(n,arr));
    }

    public static int countValid(int n, int[] arr) {
        // code here
/*        int s = arr.length;
int k =s;
        if(n == 1) return s;
        int count= (int)Arrays.stream(arr).filter(e->e==0).count();
        if( count!=0 ){
            k=s-count;
        }

        return ((9*(int)Math.pow(10,n-1))-((9-k)*(int)Math.pow(10-s,n-1)));*/


        int s = arr.length;
        int k =s;
        int count= (int)Arrays.stream(arr).filter(e->e==0).count();
        if( count!=0 ){
            k=s-count;
        }


        if(n == 1) return k;


        return ((9*(int)Math.pow(10,n-1))-((9-k)*(int)Math.pow(10-s,n-1)));
    }
}
