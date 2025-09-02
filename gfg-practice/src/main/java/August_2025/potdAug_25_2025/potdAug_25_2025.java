package August_2025.potdAug_25_2025;

import java.util.Arrays;

public class potdAug_25_2025 {
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 5};
        int k = 3;
        int result = maxMedian(arr, k);
        System.out.println(result);
    }

    private static int maxMedian(int[] arr, int k){
        int n = arr.length;
        Arrays.sort(arr);

        int median = arr[n/2];
        if(n%2==0){
            median += arr[(n/2) -1];
            median/=2;
        }

        int lo = median;
        int hi = median + k;
        int res = -1;

        while(lo <= hi){
            int mid = (lo+hi)/2;

            if(isPossible(arr,mid,k)){
                res=mid;
                lo = mid+1;
            }else{
                hi=mid-1;
            }
        }

        return res;
    }

    private static boolean isPossible(int[] arr, int target, int k){
        int n = arr.length;

        //for odd arr length
        // increase all elements from median to end
        if(n%2!=0){
            for(int i=n/2;i<n;i++){
               if(arr[i]<target)
                   k-=(target - arr[i]);

               if(k<0) break;
            }
        }else{//even arr
            //handle for the median elements
            k -= (2 * target - (arr[n / 2] + arr[n / 2 - 1]));

            //handle remaining after median elementes
            for (int i = n / 2 + 1; i < n; ++i) {
                if (arr[i] < target)
                    k -= (target - arr[i]);

                if(k < 0) break;
            }
        }

        return k>=0;
    }
}
