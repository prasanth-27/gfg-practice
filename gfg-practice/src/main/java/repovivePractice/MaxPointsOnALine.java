package repovivePractice;

import java.util.HashMap;

public class MaxPointsOnALine {

    public static void main(String[] args) {
        int[][] points = new int[][]{ {1,1}, {3,2}, {5,3}, {4,1}, {2,3}, {1,4}};
        System.out.println(maxPoints(points));

        points = new int[][]{ {2,3}, {3,3}, {-5,3}};
        System.out.println(maxPoints(points));


    }

    private static int maxPoints(int[][] points){
        //slope vs count
        HashMap<Double, Integer> mp = new HashMap<>();

        int ans=1;

        for(int i=0;i<points.length-1;i++){
            mp.clear();
            int x=points[i][0];
            int y=points[i][1];

            for (int j=i+1;j<points.length;j++){

                int a = x-points[j][0];
                int b = y-points[j][1];

                Double key = Double.valueOf(b)/Double.valueOf(a);

                //to handle -0.0 != 0.0 for doubles and floats
                if(key == -0.0){
                    key = 0.0;
                }

                if(key == Double.NEGATIVE_INFINITY)
                    key = Double.POSITIVE_INFINITY;

                mp.put(key, mp.getOrDefault(key,1)+1);

            }

            ans = Math.max(mp.entrySet().stream().map(e->e.getValue()).max(Integer::compare).get(), ans);
        }

        return ans;
    }

    private static int gcd(int a, int b) {

        return b==0 ? a : gcd(b,a%b);
    }
}
