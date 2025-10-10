package October_2025.potdOct_01_2025;

import java.util.ArrayList;
import java.util.Arrays;

public class potdOct_01_2025 {
    public static void main(String[] args) {
        int[] arr = {1, 3, 3};

        ArrayList<ArrayList<Integer>> permutations = uniquePerms(arr);

        System.out.println(permutations);
        for (ArrayList<Integer> perm : permutations) {
            for (int num : perm) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    private static void backtrack(int[] arr, boolean[] visited, ArrayList<Integer> curr, ArrayList<ArrayList<Integer>> res){
        //recursion end case
        if(curr.size()==arr.length){
            res.add(new ArrayList<>(curr));
            return;
        }

        // Iterate through the array to build permutations
        for (int i = 0; i < arr.length; i++) {

            // Skip already visited elements or duplicates
            if(visited[i] || (i>0 && arr[i]==arr[i-1]&&!visited[i-1]))
                continue;


            // Choose arr[i] for the current permutation
            curr.add(arr[i]);
            visited[i]=true;

            // Recursively build the next part of the permutation
            backtrack(arr,visited,curr,res);

            // Backtrack
            curr.remove(curr.size()-1);
            visited[i]=false;

        }

    }

    private static ArrayList<ArrayList<Integer>> uniquePerms(int[] arr) {
        // code here
        Arrays.sort(arr);
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> curr = new ArrayList<>();
        boolean[] visited = new boolean[arr.length];

        backtrack(arr,visited,curr,res);

        return res;
    }
}
