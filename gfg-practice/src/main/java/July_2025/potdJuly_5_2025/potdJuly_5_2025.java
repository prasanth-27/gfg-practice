package July_2025.potdJuly_5_2025;

import java.util.Arrays;

public class potdJuly_5_2025 {

    public static void main(String[] args) {

        int[] arr = new int[]{4,3,5,1};
        System.out.println(maxSumOfMinNumbers(arr));

        arr = new int[]{1,2,3};
        System.out.println(maxSumOfMinNumbers(arr));

        arr = new int[]{4,3};
        System.out.println(maxSumOfMinNumbers(arr));
    }

    private static int maxSumOfMinNumbers(int[] arr){
        int n =arr.length;
        if(n==2){
            return Arrays.stream(arr).sum();
        }

        int i=0,j=1,sum=0;

        while(j<n){
            sum=Math.max(sum,arr[i]+arr[j]);
            i++;
            j++;
        }
        return sum;
    }
}
