package August_2025.potdAug_04_2025;

public class potdAug_04_2025 {
    public static void main(String[] args) {
        int[][] mat = new int[][]{
                new int[] {1, 2, -1, -4, -20},
                new int[] {-8, -3, 4, 2, 1},
                new int[] {3, 8, 10, 1, 3},
                new int[] {-4, -1, 1, 7, -6}
        };

        System.out.println(maxSum(mat));
    }

    private static int maxSum(int[][] mat){
        int n = mat.length;
        int m = mat[0].length;

        int[] kadnesPrefixByCloumns = new int[n];
        int maxSum = Integer.MIN_VALUE;
        int rowsum=0;

        for(int left=0;left<m;left++){

            //reset kadanesPrefix
            //kadnesPrefixByCloumns = new int[n];
            for(int i =0;i<n;i++){
               kadnesPrefixByCloumns[i]=0;
            }

            for(int right=left;right<m;right++){
                for(int row=0;row<n;row++)
                    kadnesPrefixByCloumns[row]+=mat[row][right];

                rowsum = kadane(kadnesPrefixByCloumns);

                maxSum = Math.max(maxSum, rowsum);
            }

        }
        return maxSum;
    }

    private static int kadane(int[] arr){
        int n = arr.length;
        int max = Integer.MIN_VALUE;
        int sum=0;

        for(int i=0;i<n;i++){
            sum+=arr[i];

            if(sum>max){
                max=sum;
            }

            //reset sum to restart kadane
            if(sum<0){
                sum=0;
            }

        }

        return max;
    }
}
