package September_2025.potdSept_22_2025;

import jdk.jshell.spi.SPIResolutionException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class potdSept_22_2025 {
    public static void main(String[] args) {
        int[] arr = new int[]{10,20,35,50,10,70,30};
        System.out.println(maxOfMins(arr));

        arr = new int[]{10, 20, 30, 50, 10, 70, 30};
        System.out.println(maxOfMins(arr));
    }

    private static ArrayList<Integer> maxOfMins(int[] arr){
        int n = arr.length;

        Stack<Integer> st = new Stack<>();
        int[] prevArr = new int[n];
        int[] nextArr = new int[n];

        Arrays.fill(prevArr,-1);
        Arrays.fill(nextArr,n);

        for(int i=0;i<n;i++){

            while (!st.empty() && arr[st.peek()]>=arr[i]){
                st.pop();
            }
            if(!st.empty()) prevArr[i]=st.peek();

            st.push(i);
        }

        System.out.println(Arrays.toString(prevArr));

        st.clear();

        for(int i=n-1;i>=0;i--){

            while (!st.empty() && arr[st.peek()]>=arr[i]){
                st.pop();
            }
            if(!st.empty()) nextArr[i]=st.peek();

            System.out.println("_____"+Arrays.toString(nextArr));

            st.push(i);
        }

        System.out.println(Arrays.toString(nextArr));

        ArrayList<Integer> res = new ArrayList<>(Collections.nCopies(n,0));

        for(int i =0;i<n;i++){

            int window=(nextArr[i] - prevArr[i] -1);

            res.set(window-1,Math.max(res.get(window-1), arr[i]));
        }

        for(int i=n-1;i>=0;i--){
            if(res.get(i)==0)
                res.set(i,res.get(i+1));
        }

        return res;
    }
}
