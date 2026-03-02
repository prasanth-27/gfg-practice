package Feb_2026;

public class TrappingRainWater {

    public static void main(String[] args) {
        int[] arr = { 2, 1, 5, 3, 1, 0, 4 };
        System.out.println(trapWater_optimized(arr));

        arr = new int[]{ 1,2,3,4};
        System.out.println(trapWater_optimized(arr));

        arr = new int[]{ 1,0,2,0,3,0,4 };
        System.out.println(trapWater_optimized(arr));

    }

    //For each element find max element on left and max element on right
    //then trapped water += min(leftMax,rightMax)-currentHeight
    //O(n^2) O(1)
    private static int trapWater_brute(int[] arr){
        int water=0;

        //foreach element
        for(int curr=1;curr<arr.length-1;curr++){

            //find max on left
            int left=arr[curr];
            for(int i=0;i<curr;i++)
                left=Math.max(arr[i],left);

            //find max on right
            int right = arr[curr];
            for(int i=curr+1;i<arr.length;i++)
                right=Math.max(arr[i],right);

            //trapped water at the element = min(left,right)-current
            water += (Math.min(left,right)-arr[curr]);
        }

        return water;
    }

    //For each calculate max left and max right in each pass
    //water = min(left,right)-curr
    //O(n) O(n)
    private static int trapWater_better(int[] arr){
        int water=0;
        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];

        left[0]=arr[0];
        for(int i=1;i<n;i++)
            left[i]=Math.max(arr[i], left[i-1]);

        right[n-1]=arr[n-1];
        for(int i=n-2;i>=0;i--)
            right[i]=Math.max(arr[i], right[i+1]);

        for(int i=0;i<n;i++){
            water+=(Math.min(left[i],right[i])-arr[i]);
        }

        return water;
    }

    //
    //O(n) O(1)
    private static int trapWater_optimized(int[] arr){
        int n = arr.length;
        int leftMax=arr[0];
        int rightMax=arr[n-1];
        int left=1;
        int right=n-2;

        int water=0;

        while(left<=right){

            //leftmax is smaller, update the water for left point
            if(leftMax<rightMax){
                //update water
                water+=Math.max(0, leftMax-arr[left]);

                //update leftmax
                leftMax = Math.max(leftMax, arr[left]);

                //update left pointer
                left++;
            }
            //right max is smaller, update water for right pointer
            else{
                //update water
                water+=Math.max(0,rightMax-arr[right]);

                //update rightMax
                rightMax = Math.max(rightMax, arr[right]);

                //update right pointer
                right--;
            }
        }

        return water;
    }

}
