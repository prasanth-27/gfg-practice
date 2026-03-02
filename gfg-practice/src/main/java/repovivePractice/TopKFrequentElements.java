package repovivePractice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class TopKFrequentElements {
    public static void main(String[] args) {
        int[] arr = new int[]{1,1,1,2,2,3};
        int k =2;

        Arrays.stream(topk(arr,k)).forEach(System.out::println);
    }

    //O(n)map O(nlogn)pq O(n)+O(n)
    //using max heap
    private static int[] topk(int[] arr, int k){
        int[] ans = new int[k];

        HashMap<Integer,Integer> mp = new HashMap<>();

        for(int e: arr)
            mp.put(e, mp.getOrDefault(e,0)+1);

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o2[1],o1[1]);
            }
        });
        //PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->{return mp.get(b)-mp.get(a)});

        for(int e: mp.keySet())
            pq.add(new int []{e, mp.get(e)});

        for(int i=0;i<k;i++){
            ans[i]=pq.poll()[0];
        }

        return ans;
    }

    //O(n) O(n)+O(K)
    //using bucket sort
/*    private static int[] topkMinHeap(int[] arr, int k){
        int[] ans = new int[k];

        HashMap<Integer,Integer> mp = new HashMap<>();

        for(int e: arr)
            mp.put(e, mp.getOrDefault(e,0)+1);

        //bucket sort
        int[]set[] bucket = new int[arr.length+1][];


        return ans;
    }*/
}
