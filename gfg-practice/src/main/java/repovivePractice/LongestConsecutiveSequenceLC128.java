package repovivePractice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class LongestConsecutiveSequenceLC128 {

    public static void main(String[] args) {
        int[] arr = new int[]{1,0,1,2};
        System.out.println(longestConsecutive(arr));

        arr = new int[]{0,3,7,2,5,8,4,6,0,1};
        System.out.println(longestConsecutive(arr));

        arr = new int[]{0,0,0,0};
        System.out.println(longestConsecutive(arr));
    }

    public int longestConsecutive2(int[] nums) {
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int n : nums) {
            if (!map.containsKey(n)) {
                int left = (map.containsKey(n - 1)) ? map.get(n - 1) : 0;
                int right = (map.containsKey(n + 1)) ? map.get(n + 1) : 0;
                // sum: length of the sequence n is in
                int sum = left + right + 1;
                map.put(n, sum);

                // keep track of the max length
                res = Math.max(res, sum);

                // extend the length to the boundary(s)
                // of the sequence
                // will do nothing if n has no neighbors
                map.put(n - left, sum);
                map.put(n + right, sum);
            }
            else {
                // duplicates
                continue;
            }
        }
        return res;
    }

    public static int longestConsecutive(int[] nums) {
        int length=0, longest=0;

        HashSet<Integer> s = new HashSet<>();

        for(int num:nums)
            s.add(num);

        for(int num: s){
            if(!s.contains(num-1)){
                int curr=num;
                length=1;
                while(s.contains(curr+1)){
                    curr++;
                    length++;
                }
                longest = Math.max(length, longest);
            }

        }

        return longest;
    }
}
