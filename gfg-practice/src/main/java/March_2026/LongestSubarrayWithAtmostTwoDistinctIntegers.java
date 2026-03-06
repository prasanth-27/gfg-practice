package March_2026;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class LongestSubarrayWithAtmostTwoDistinctIntegers {
    public static void main(String[] args) {
        int[] arr = {1,2,1};
        System.out.println(totalElements(arr));

        arr = new int[] {3,1,2,2,2,2};
        System.out.println(totalElements(arr));

        arr = new int[] {3,1,2};
        System.out.println(totalElements(arr));
    }

    //atmost == 0,1,2
    private static int totalElements(int[] arr){
        //two pointer
        //j moves ahead
        //maintain map of visited integers and count
        //exceeds limit, move i until in range

        HashMap<Integer, Integer> visited = new HashMap<>();
        int i=0,j=0;
        int ans=0;

        while(j<arr.length){
            //contains just increment the j pointer
            if(visited.containsKey(arr[j])) {
                visited.put( arr[j], visited.get(arr[j])+1 );
            }
            //not contains add to set and check the length
            //if length > 2 move i pointer untill <=2
            else{
                visited.put(arr[j],1);
                while (visited.size()>2){
                    visited.put(arr[i], visited.get(arr[i])-1);
                    if(visited.get(arr[i])<=0){
                        visited.remove(arr[i]);
                    }
                    i++;
                }
            }

            //finally recalculate ans
            ans=Math.max(ans, j-i+1);

            j++;
        }
        return ans;
    }
}
