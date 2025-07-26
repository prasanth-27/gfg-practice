package potdJuly_25_2025;

public class potdJuly_25_2025 {
    public static void main(String[] args) {
        int[] arr = new int[]{8, -8, 9, -9, 10, -11, 12};
        System.out.println(mymaxSum(arr));
        System.out.println(maxSum(arr));

        arr = new int[]{10, -3, -4, 7, 6, 5, -4, -1};
        System.out.println(mymaxSum(arr));
        System.out.println(maxSum(arr));
    }

    //max sum in circular array = toatal sum - minsumof array

    //Find total sum
    //Find Max Sub array sum
    //Find Min Sub array sum
    //now if totalsum=minsum return maxsum
    //return max(maxsum, total-minsum)
    //when array is warped and joined by ends, max sum will either be
    // the sum of total elements
    // or total-minkadanesum
    // or if minkadanesum=totalsum max will be maxkadanesum
    private static int maxSum(int[] arr){
        int n = arr.length;
        int maxSum=arr[0];
        int minSum=arr[0];
        int totalSum=0;
        int runningMin=0;
        int runningMax=0;

        for(int i =0;i<n;i++){

            runningMin=Math.min(runningMin+arr[i],arr[i]);
            minSum=Math.min(minSum,runningMin);

            runningMax=Math.max(runningMax+arr[i],arr[i]);
            maxSum=Math.max(maxSum,runningMax);

            totalSum+=arr[i];
        }

        int normalSum = maxSum;
        int circularSum = totalSum - minSum;

        // If the minimum subarray is equal to total Sum
        // then we just need to return normalSum
        if(minSum == totalSum)
            return normalSum;

        return Math.max(normalSum, circularSum);
    }


    //This doesn't work as it do not know when to stop
    private static int mymaxSum(int[] arr){
        int n = arr.length;
        int maxSum=0;

        int sum=0,start=0;
        for(int i=0; i<2*n; i++){

                sum += arr[i % n];

                System.out.println("Iteration i: " + i + "\telement: " + arr[i % n] + "\tSum: " + sum);
                if (sum <= 0) {
                    sum = 0;
                    continue;
                }

                maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }
}
