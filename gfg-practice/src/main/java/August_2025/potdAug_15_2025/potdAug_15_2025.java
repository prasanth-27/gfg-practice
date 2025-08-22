package August_2025.potdAug_15_2025;

import java.util.ArrayList;
import java.util.Arrays;

public class potdAug_15_2025 {
    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {4, 5}, {6, 7}, {8, 10}};
        int[] newInterval = {5, 6};
        insertInterval(intervals,newInterval).stream().forEach(e->System.out.println(Arrays.toString(e)));
    }

    private static ArrayList<int[]> insertInterval(int[][] intervals, int[] newInterval){
        int n = intervals.length;
        ArrayList<int[]> res = new ArrayList<>();

        int i=0;
        //Add all intervals where end < new start
        while(i<n && intervals[i][1] < newInterval[0]){
            res.add(intervals[i]);
            i++;
        }

        //Merge overlapping intervals
        while(i<n && intervals[i][0] <= newInterval[1]){
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        res.add(newInterval);

        //add remaining intervals
        while (i<n){
            res.add(intervals[i]);
            i++;
        }

        return res;
    }
}
