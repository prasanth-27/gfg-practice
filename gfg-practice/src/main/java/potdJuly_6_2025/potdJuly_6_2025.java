package potdJuly_6_2025;

import java.util.*;

public class potdJuly_6_2025 {

    public static void main(String[] args) {
        int[] a = new int[] {1,4,2,3};
        int[] b = new int[] {2,5,1,6};
        int k = 3;
        System.out.println(topMaxSums(a,b,k));

        a = new int[] {3,2};
        b = new int[] {1,4};
        k = 2;
        System.out.println(topMaxSums(a,b,k));

        a = new int[] {4,1,6,1,10};
        b = new int[] {6,5,2,7,8};
        k = 4;
        System.out.println(topMaxSums(a,b,k));
    }

    private static ArrayList<Integer> topMaxSums(int[] a, int[] b, int k){

        ArrayList<Integer> sums = new ArrayList<>();
        int n = a.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((e1,e2)-> e2[0]-e1[0]);
        LinkedHashSet<String> st = new LinkedHashSet<>();

        Arrays.sort(a);
        Arrays.sort(b);

        int sum = a[n-1]+b[n-1];
        int i=n-1,j=n-1;
        pq.add(new int[]{sum,n-1,n-1});
        st.add(i+"_"+j);

        while(sums.size()<k){

            int[] top = pq.poll();
            sum=top[0];
            i=top[1];
            j=top[2];

            sums.add(sum);

            if(j-1>=0 && !st.contains(i+"_"+(j-1))){
                pq.add(new int[]{a[i]+b[j-1],i,j-1});
                st.add(i+"_"+(j-1));
            }

            if(i-1>=0 && !st.contains((i-1)+"_"+j)){
                pq.add(new int[]{a[i-1]+b[j],i-1,j});
                st.add((i-1)+"_"+j);
            }

        }

        return sums;
    }
}
