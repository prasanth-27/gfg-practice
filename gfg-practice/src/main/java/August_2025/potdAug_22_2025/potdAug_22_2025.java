package August_2025.potdAug_22_2025;

public class potdAug_22_2025 {
    public static void main(String[] args) {

    }

    private static int median(int[][] mat){
        int n = mat.length;
        int m = mat[0].length;

        int min=Integer.MAX_VALUE;
        int max= Integer.MIN_VALUE;

        for(int i=0;i<n;i++){
            if(mat[i][0] < min){
                min = mat[i][0];
            }

            if(max < mat[i][m-1]){
                max = mat[i][m-1];
            }
        }

        // as n and m are odd, n*m is also odd.
        //So median will be at (n*m+1)/2 pos and there will be n*m/2 elements on both sides.
        //so we run a binary search on the elements minval to maxval and find such element which has n*m/2 elements before it.

        int desiredPlace = (n*m+1)/2;

        while(min<max){
            int mid = min+(max-min)/2;

            int places=0;
            for(int i=0;i<n;i++){
                places+=placeCounter(mat[i],mid);
            }

            if(places<desiredPlace){
                min=mid+1;
            }else{
                max=mid;
            }
        }

        return min;
    }

    private static int placeCounter(int[] arr, int val){
        int n = arr.length;
        int low=0;
        int high=n;

        while(low<high){
            int mid = low+(high-low)/2;

            if(arr[mid]<=val){
                low = mid+1;
            }else{
                high=mid;
            }
        }

        return low;

    }
}
