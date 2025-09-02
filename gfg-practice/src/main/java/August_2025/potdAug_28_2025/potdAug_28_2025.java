package August_2025.potdAug_28_2025;

public class potdAug_28_2025 {
    public static void main(String[] args) {
        int[] arr = new int[]{1,1};
        int k =2;
        System.out.println(maxNum1s(arr,k));

        //1, 0, 0, 1, 0, 1, 0, 1
        arr = new int[]{ 1, 0, 0, 1, 0, 1, 0, 1};
        k =2;
        System.out.println(maxNum1s(arr,k));
    }

    private static int maxNum1s(int[] arr,int k){
        int n = arr.length;

        int count=0;
        int left=0,right=0;
        int res=-1;

        while(right<n){
            if(arr[right]==0) count++;

            while(count > k){
                if(arr[left]==0) count--;
                left++;
            }
            res=Math.max(res, right-left+1);
            right++;
        }
        return res;
    }
}
