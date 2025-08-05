package July_2025.potdJuly_7_2025;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class potdJuly_7_2025 {

    public static void main(String[] args) {

        int[] arr = new int[]{1,3,2,4};
        System.out.println(nextGreatestElement(arr));
    }

    private static ArrayList<Integer> nextGreatestElement(int[] arr){
        int n = arr.length;

        ArrayList<Integer> ngs = new ArrayList<>();
        for(int i=0;i<n;i++){
            ngs.add(-1);
        }

        System.out.println(""+ngs+" - "+ngs.size());

        Stack<Integer> st = new Stack<>();

        for(int i=2*n-1; i>=0 ;i--){

            System.out.println(st);
            System.out.println(ngs);

            int curr = arr[i%n];
            while(!st.empty() && st.peek()<=curr){
                st.pop();
            }

            if(!st.empty() && i<n){
                ngs.set(i,st.peek());
            }

            st.push(curr);
        }

        return ngs;
    }
}
