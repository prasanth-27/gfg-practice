package August_2025.potdAug_24_2025;

import java.util.Arrays;

public class potdAug_24_2025 {
    public static void main(String[] args) {
        int[] arr = {5, 5, 5, 5, 10, 5, 5};
        int k = 3, m = 2;

        System.out.println(minDaysBloom(arr, k, m));
    }

    private static int minDaysBloom(int[] arr, int k, int m){
        int lo=0;
        int hi = Arrays.stream(arr).max().getAsInt();
        int res=-1;

        while(lo<=hi){
            int mid = (lo+hi)/2;
            if(isBoquesPossible(arr,k,m,mid)){//if boques possible check in lower rsnge for better ans
                res = mid;
                hi=mid-1;
            }else{// current days not sufficient check in higher range.
                lo=mid+1;
            }
        }

        return res;
    }

    private static boolean isBoquesPossible(int[] arr, int k, int m, int day){
        int count=0;
        int boques=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]<=day){
                count++;
            }else{
                boques+=(count/k);
                count=0;
            }
        }

        boques += count / k; // additional to safeguard the last iteration where count was increased but not contributed to boquets.
        return boques>=m;
    }
}
