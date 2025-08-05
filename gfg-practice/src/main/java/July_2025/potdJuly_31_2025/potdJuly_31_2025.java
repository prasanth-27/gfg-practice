package July_2025.potdJuly_31_2025;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class potdJuly_31_2025 {
    public static void main(String[] args) {

        int[][] intervals = new int[][]{
                new int[]{1,3},
                new int[]{4,6},
                new int[]{3,4},
                new int[]{5,8}
        };

        int k=2;
        System.out.println(powerfunNum(intervals,k));
        System.out.println(rangeOfPowerfunNum(intervals,k).stream().map(e-> Arrays.toString(e)).collect(Collectors.toUnmodifiableList()));

    }

    private static int powerfunNum(int[][] intervals, int k){
        int n = intervals.length;
        TreeMap<Integer,Integer> mp = new TreeMap<>();

        for(int i=0;i<n;i++){
            int start = intervals[i][0];
            int end = intervals[i][1];

            mp.put(start, mp.getOrDefault(start,0)+1);
            mp.put(end+1,mp.getOrDefault(end+1,0)-1);
        }

        int prefix=0;
        int ans=-1;
        for(Map.Entry<Integer,Integer> entry : mp.entrySet()){
            int pos = entry.getKey();
            int delta = entry.getValue();

            if(delta>=0){
                prefix+=delta;
                if(prefix>=k){
                    ans=pos;
                }
            }else{
                if(prefix>=k){
                    ans=pos-1;
                }
                prefix+= delta;
            }
        }

        return ans;
    }

    private static ArrayList<int[]> rangeOfPowerfunNum(int[][] intervals, int k){
        int n = intervals.length;
        TreeMap<Integer,Integer> mp = new TreeMap<>();

        for(int i=0;i<n;i++){
            int start = intervals[i][0];
            int end = intervals[i][1];

            mp.put(start, mp.getOrDefault(start,0)+1);
            mp.put(end+1,mp.getOrDefault(end+1,0)-1);
        }

        int prefix=0;
        ArrayList<int[]> res = new ArrayList<>();
        boolean inRange = false;
        int rangeStart=0;
        for(Map.Entry<Integer,Integer> entry : mp.entrySet()){
            int pos = entry.getKey();
            int delta = entry.getValue();

            prefix+=delta;

            if(prefix>=k && !inRange){
                rangeStart = pos;
                inRange=true;
            }else if(prefix<k && inRange){
                res.add(new int[]{rangeStart,pos-1});
                inRange=false;
            }
        }

        return res;
    }
}
