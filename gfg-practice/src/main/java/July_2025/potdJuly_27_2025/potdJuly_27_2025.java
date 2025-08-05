package July_2025.potdJuly_27_2025;

import java.util.ArrayList;
import java.util.Arrays;

public class potdJuly_27_2025 {

    public static void main(String[] args) {

        int[][] arr =new int[][]{
                new int[]{1,-1,0},
                new int[]{-11,0,1},
                new int[]{1,-1,1}
        };

        fillMatrix(arr);

        Arrays.stream(arr).map(Arrays::toString).forEach(System.out::println);

        arr =new int[][]{
                new int[]{0,1,2,0},
                new int[]{1,2,6,2},
                new int[]{1,3,1,8}
        };

        fillMatrix(arr);

        Arrays.stream(arr).map(Arrays::toString).forEach(System.out::println);
    }

    private static void fillMatrix(int[][] arr){
        int n = arr.length;
        int m = arr[0].length;
        int cj0=1;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(arr[i][j]==0){
                    if(j==0){
                        cj0=0;
                    }else{
                        arr[i][0] = 0;
                        arr[0][j] = 0;
                    }

                }
            }
        }

        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(arr[i][0]==0 || arr[0][j]==0){
                    arr[i][j]=0;
                }
            }
        }

        if(arr[0][0]==0){
            for(int j =0;j<m;j++){
                arr[0][j]=0;
            }
        }

        if(cj0==0){
            for(int i =0;i<n;i++){
                arr[i][0]=0;
            }
        }
    }
}
