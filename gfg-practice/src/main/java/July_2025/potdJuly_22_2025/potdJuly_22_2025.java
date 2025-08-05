package July_2025.potdJuly_22_2025;

import java.util.Arrays;

public class potdJuly_22_2025 {

    public static void main(String[] args) {
        int[] arr = new int[]{1,1,1,1};

        System.out.println(missingNumber(arr));

        arr = new int[]{0,1,1,1};

        System.out.println(missingNumber(arr));

        arr = new int[]{-8,7,6,4,1};

        System.out.println(missingNumber(arr));

        arr = new int[]{5,4,5,3,2,1};

        System.out.println(missingNumber(arr));
    }

    //this doesnot work for tc 1115
    private static int missingNumber(int[] arr){
        int n = arr.length;

        if( Arrays.stream(arr).filter(e->e==1).count() == 0){
            return 1;
        }

        for(int i=0;i<n;i++){
            if(arr[i]<=0 || arr[i]>n){
                arr[i]=1;
            }
        }

        for(int i=0;i<n;i++){
            int idx = (arr[i]-1)%n;
            arr[idx] = arr[idx]%n + n;
        }

        int i;
        for( i =0;i<n;i++){
            if(arr[i]<n) break;
        }

        return i+1;
    }

    //usecycle sort
    static int missingNumber2(int[] arr) {

        int n = arr.length;
        for (int i = 0; i < n; i++) {

            // if arr[i] is within the range [1, n] and arr[i]
            // is not placed at (arr[i]-1)th index in arr
            while (arr[i] >= 1 && arr[i] <= n
                    && arr[i] != arr[arr[i] - 1]) {

                // then swap arr[i] and arr[arr[i]-1] to
                // place arr[i] to its corresponding index
                int temp = arr[i];
                arr[i] = arr[arr[i] - 1];
                arr[temp - 1] = temp;
            }
        }

        // If any number is not at its corresponding index
        // then it is the missing number
        for (int i = 1; i <= n; i++) {
            if (i != arr[i - 1]) {
                return i;
            }
        }

        // If all number from 1 to n are present then n+1
        // is smallest missing number
        return n + 1;
    }


    //partition the array so that all positive are to left side
    static int partition(int[] arr) {
        int pivotIdx = 0;
        int n = arr.length;

        for (int i = 0; i < n; i++) {

            // Move positive elements to the left
            if (arr[i] > 0) {
                int temp = arr[i];
                arr[i] = arr[pivotIdx];
                arr[pivotIdx] = temp;
                pivotIdx++;
            }
        }

        // return index of the first non-positive number
        return pivotIdx;
    }

    static int missingNumber3(int[] arr) {
        int k = partition(arr);

        // Traverse the positive part of the array
        for (int i = 0; i < k; i++) {

            // Find the absolute value to get the original number
            int val = Math.abs(arr[i]);

            // If val is within range, then mark the element at
            // index val-1 to negative
            if (val - 1 < k && arr[val - 1] > 0) {
                arr[val - 1] = -arr[val - 1];
            }
        }

        // Find first unmarked index
        for (int i = 0; i < k; i++) {
            if (arr[i] > 0) {
                return i + 1;
            }
        }

        // If all numbers from 1 to k are marked
        // then missing number is k + 1
        return k + 1;
    }
}
