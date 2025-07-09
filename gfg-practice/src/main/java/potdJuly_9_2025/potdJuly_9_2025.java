package potdJuly_9_2025;

import java.util.Arrays;
import java.util.Stack;

public class potdJuly_9_2025 {
    public static void main(String[] args) {

        int[] arr = new int[]{3,1,2,4};
        System.out.println(sumofMininSubarraysMonoStacks(arr));
    }

    private static int sumofMininSubarraysMonoStacks(int[] arr){
        int n = arr.length;
        int sum = 0;

        int[] right = new int[n];
        int[] left = new int[n];
        int[] dp = new int[n];

        Stack<int[]> st = new Stack<>();

        for(int i=0;i<n;i++){
            int count=1;
            while(!st.isEmpty() && arr[i]<st.peek()[0]){
                count+=st.pop()[1];
            }

            st.push(new int[]{arr[i],count});
            left[i]=count;
        }

        st = new Stack<>();

        for(int i=n-1;i>=0;i--){
            int count=1;
            while(!st.isEmpty() && arr[i]<=st.peek()[0]){
                count+=st.pop()[1];
            }

            st.push(new int[]{arr[i],count});
            right[i]=count;
        }

        System.out.println(Arrays.toString(left));
        System.out.println(Arrays.toString(right));


        for(int i=0;i<n;i++){
            sum+=(arr[i]*left[i]*right[i]);
        }

        return sum;
    }

    private static int sumofMininSubarraysDP(int[] arr){
        int n = arr.length;
        int sum = 0;

        int[] right = new int[n];
        for(int i =0;i<n;i++){
            right[i]=i;
        }
        int[] dp = new int[n];
        Stack<Integer> st = new Stack<>();

        System.out.println(Arrays.toString(right));

        for(int i=0;i<n;i++){
            while(!st.isEmpty() && arr[i]<arr[st.peek()]){
                right[st.pop()]=i;
            }

            st.push(i);

            System.out.println(st);
        }

        System.out.println(Arrays.toString(right));

        dp[n-1] = arr[n-1];
        for(int i=n-2;i>=0;i--){
            int r = right[i];
            if(i==r){
                dp[i] = ( n-i )* arr[i];
            } else{
                dp[i] = (r-i)*arr[i] + dp[r];
            }
        }

        System.out.println(Arrays.toString(dp));

        sum=Arrays.stream(dp).sum();

        return sum;
    }

}
