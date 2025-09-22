package September_2025.potdSept_12_2025;

import java.util.Arrays;

public class potdSept_12_2025 {
    public static void main(String[] args) {
        int[] arr = {1, 5, 8, 10};
        int k = 2;
        System.out.println(getMinDiff(arr, k));

        arr = new int[]{3, 9, 12, 16, 20};
        k = 3;
        System.out.println(getMinDiff(arr, k));

        arr = new int[]{3, 4, 5, 6, 7};
        k = 3;
        System.out.println(getMinDiff(arr, k));
    }

    private static int getMinDiff(int[] arr, int k){
        int n = arr.length;
        if(n==1) return 0;

        Arrays.sort(arr);

        int ans=arr[n-1]-arr[0];

        int min=arr[0];
        int max=arr[n-1];

        for(int i=1;i<n;i++){
            if(arr[i]-k<0) continue;

            min = Math.min(arr[0]+k, arr[i]-k);
            max = Math.max(arr[n-1]-k, arr[i-1]+k);

            ans = Math.min(ans, max-min);
        }

        return ans;
    }

}
