package July_2025.potdJuly_11_2025;

import java.util.Arrays;

public class potdJuly_11_2025 {

    public static void main(String[] args) {

        int[][] mat = new int[][] {new int[]{1,3,3}, new int[]{2,1,4}, new int[]{0,6,4}}; //[[1, 3, 3], [2, 1, 4], [0, 6, 4]]
        System.out.println(maxGoldMineTravel(mat));

        //[[1, 3, 1, 5], [2, 2, 4, 1], [5, 0, 2, 3], [0, 6, 1, 2]]
        mat = new int[][] {new int[]{1,3,1,5}, new int[]{2,2,4,1}, new int[]{5,0,2,3}, new int[]{0,6,1,2}}; //[[1, 3, 3], [2, 1, 4], [0, 6, 4]]
        System.out.println(maxGoldMineTravel(mat));
    }


    private static int maxGoldMineTravel(int[][] mat){
        int n = mat.length;
        int m = mat[0].length;
        int ans=0;

        for(int y=m-2;y>=0;y--){
            for(int x=0;x<n;x++){
                int topRight=0, right=0, bottomRight=0;
                if(x-1>=0&& y+1<m){
                    topRight=mat[x-1][y+1];
                }
                if(y+1<m){
                    right=mat[x][y+1];
                }
                if(x+1<n && y+1<m){
                    bottomRight=mat[x+1][y+1];
                }

                mat[x][y]+=Math.max(Math.max(topRight,right),bottomRight);

            }
        }

        for(int i=0;i<n;i++){
            ans=Math.max(ans,mat[i][0]);
        }

        return ans;
    }
}
