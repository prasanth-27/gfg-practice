package potdjuly_26_2025;

import java.util.ArrayList;

public class potdJuly_26_2025 {

    public static void main(String[] args) {
        int[] arr = new int[]{2, 2, 3, 1, 3, 2, 1, 1};

        System.out.println(elementsWithFreq(arr));
    }

    //Extended Boyer - Moore Voting Algorithm
    private static ArrayList<Integer> elementsWithFreq(int[] arr){
        int n = arr.length;
        int e1=0,e2=0,c1=0,c2=0;

        for(int i =0;i<n;i++){
            int num = arr[i];

            if(c1==0 && num!=e2){
                e1=num;
                c1=1;
            }else if(c2==0 && num!=e1){
                e2=num;
                c2=1;
            }else if(num==e1){
                c1++;
            }else if(num==e2){
                c2++;
            }else{
                c1--;
                c2--;
            }
        }

        c1=0;
        c2=0;
        for(int e:arr){
            if(e==e1){
                c1++;
            }else if(e==e2){
                c2++;
            }
        }

        ArrayList<Integer> res = new ArrayList<>();
        if(c1>(n/3)) res.add(e1);
        //if(c2>(n/3)) res.add(e2);
        if(c2>(n/3)){
            if(e2>e1){
                res.add(e2);
            }else{
            res.addFirst(e2);
            }
        }

        //res.sort(Integer::compare);

        return res;
    }
}
