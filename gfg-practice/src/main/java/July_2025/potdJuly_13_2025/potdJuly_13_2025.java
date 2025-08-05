package July_2025.potdJuly_13_2025;

import java.lang.reflect.Array;
import java.util.Arrays;

public class potdJuly_13_2025 {

    public static void main(String[] args) {

        int[] arr = new int[] {4, 6, 1, 2, 3, 8};

        System.out.println(maxSumofNonLis(arr));
    }

    private static int maxSumofNonLis(int[] arr){
        int n = arr.length;

        int total = Arrays.stream(arr).sum();

        int maxLisLen = 1;
        int minLisSum = total;

        int[] dpLisLen = new int[n];
        int[] dpMinLisSum = new int[n];

        for(int i=0;i<n;i++){
            dpLisLen[i] =1;
            dpMinLisSum[i] = arr[i];
        }

        for(int i=0;i<n;i++){
            for(int j =0;j<i;j++){
                if(arr[j]<arr[i]){

                    int currLen = dpLisLen[j] + 1;
                    int currSum = dpMinLisSum[j] + arr[i];

                    if(currLen > dpLisLen[i]){
                        dpLisLen[i] = currLen;
                        dpMinLisSum[i] = currSum;
                    } else if (currLen == dpLisLen[i]) {
                        dpMinLisSum[i] = Math.min(dpMinLisSum[i],currSum);
                    }
                }

                if(dpLisLen[i]>maxLisLen) {
                    maxLisLen = dpLisLen[i];
                    minLisSum = dpMinLisSum[i];
                } else if (dpLisLen[i] == maxLisLen) {
                    minLisSum = Math.min(minLisSum, dpMinLisSum[i]);
                }

            }
        }

        return total - minLisSum;
    }
}
