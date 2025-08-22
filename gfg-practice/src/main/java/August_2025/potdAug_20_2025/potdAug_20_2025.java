package August_2025.potdAug_20_2025;

public class potdAug_20_2025 {
    public static void main(String[] args) {
        int[][] mat = new int[][]{{6,7,8},{9,1,2},{3,4,5}};
        int x = 10;

        System.out.println(searchMatrix(mat, x));
    }

    private static boolean searchMatrix(int[][] mat, int x){
        int n = mat.length;
        int m = mat[0].length;

        //boolean ans = false;
        /*
        How erver rotated clockwise or anti clockwise, the array will increase first and fall down and increase.
         */

        int low=0, high=n*m-1;

        while(low<=high){
            int mid = low+(high-low)/2;

            int midRow=mid/m;
            int midCol=mid%m;
            int midVal = mat[midRow][midCol];

            if(midVal == x){
                return true;
            }

            int lowRow = low/m;
            int lowCol = low%m;
            int lowVal = mat[lowRow][lowCol];

            if(lowVal <= midVal){
                if(lowVal <= x & x <midVal){
                    high = mid-1;
                }else{
                    low = mid+1;
                }
            }else{

                int highRow = high/m;
                int highCol = high%m;
                int highVal = mat[highRow][highCol];

                if(midVal<x && x<=highVal){
                    low = mid+1;
                }else{
                    high = mid-1;
                }
            }
        }
        return false;
    }
}
