package July_2025.potdJuly_8_2025;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class potdJuly_8_2025 {

    public static void main(String[] args) {

        int[] arr = new int[]{2,1,1,3,2,1};
        System.out.println(nextElementWithgreaterFrequency(arr));

        arr = new int[]{5,1,5,6,6};
        System.out.println(nextElementWithgreaterFrequency(arr));
    }

    private static ArrayList<Integer> nextElementWithgreaterFrequency(int[] arr){
        int n = arr.length;

        ArrayList<Integer> result = new ArrayList<>();
        for(int i=0;i<n;i++){
            result.add(-1);
        }

        HashMap<Integer,Integer> frequency = new HashMap<>();
        for(int i=0;i<n;i++){
            frequency.put(arr[i], frequency.getOrDefault(arr[i],0)+1);
        }

        Stack<int[]> st = new Stack<>();

        for(int i = n-1; i>=0;i--){
            int curr = arr[i];

            while(!st.empty() && (st.peek())[1] <= frequency.get(curr)){
                st.pop();
            }

            if(!st.empty() && i<n){
                result.set(i,st.peek()[0]);
            }

            st.push(new int[]{curr,frequency.get(curr)});
        }

        return result;
    }
}
