package July_2025.potdJuly_30_2025;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.PriorityQueue;

public class Practice_sortElementsbyDecreasingFrequency {

    public static void main(String[] args) {
        int[] arr = new int[]{5, 5, 4, 6, 4};
        System.out.println(sortByFreq(arr));
    }

    private static ArrayList<Integer> sortByFreq(int[] arr){
        int n = arr.length;
        ArrayList<Integer> res = new ArrayList<>();

        LinkedHashMap<Integer,Integer> elefreq = new LinkedHashMap<>();

        for(int i=0;i<n;i++){
            elefreq.put(arr[i], elefreq.getOrDefault(arr[i],0)+1);
        }

        System.out.println(elefreq);

        PriorityQueue<int[]> pq = new PriorityQueue<>((e1,e2)-> e1[1]==e2[1]? e1[0]-e2[0] :e2[1] - e1[1]);

        pq.stream().forEach(e -> System.out.println(Arrays.toString(e)));

        for(int ele : elefreq.keySet()){
            //System.out.println(ele);
            pq.add(new int[]{ele, elefreq.get(ele)});
        }

        //pq.stream().forEach(e -> System.out.println(Arrays.toString(e)));

        while(!pq.isEmpty()){
            res.add(pq.poll()[0]);
            //pq.stream().forEach(e -> System.out.println(Arrays.toString(e)));
        }

        return res;
    }
}
