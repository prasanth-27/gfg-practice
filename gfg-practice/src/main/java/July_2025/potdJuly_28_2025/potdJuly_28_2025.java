package July_2025.potdJuly_28_2025;

import java.util.Arrays;

public class potdJuly_28_2025 {
    public static void main(String[] args) {
        int[][] mat = new int[][]{
                new int[]{1,2,3},
                new int[]{4,2,3},
                new int[]{3,2,1}
        };

        System.out.println(minOps(mat));

        mat = new int[][]{
                new int[]{1,2},
                new int[]{3,4}
        };

        System.out.println(minOps(mat));
    }

    //mat is a square matrix
    private static int minOps(int[][] mat){
        int n = mat.length;

        int maxSum=0;

        int totalSum = Arrays.stream(mat).map(e -> Arrays.stream(e).sum()).reduce(0, (a,b)->a+b);

        //row max
        maxSum = Arrays.stream(mat).map(e -> Arrays.stream(e).sum()).max(Integer::compare).get();

        //column max
        for(int i = 0; i <n;i++){
            int sum=0;
            for(int j =0;j<n;j++){
                sum+=mat[j][i];
            }

            maxSum = Math.max(maxSum,sum);
        }

        return (int)((n*maxSum) - totalSum);


    }
}
