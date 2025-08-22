package August_2025.potdAug_12_2025;

import java.util.ArrayList;
import java.util.Arrays;

public class potdAug_12_2025 {
    public static void main(String[] args) {
        int[] prices = new int[]{3, 2, 1, 4};
        int k =2;
        System.out.println(minMaxCost(prices,k));
    }

    private static ArrayList<Integer> minMaxCost(int[] prices, int k){
        int n = prices.length;

        Arrays.sort(prices);
        int minCost=0;
        int maxCost=0;

        for(int i=0;i<n;i++){
            minCost+=prices[i];
            n-=k;
        }

        int lb=0;
        for(int i=prices.length-1;i>=lb;i--){
            //System.out.println(prices[i]);
            maxCost+=prices[i];
            lb+=k;
        }

        ArrayList<Integer> res = new ArrayList<>();
        res.add(minCost);
        res.add(maxCost);

        return res;
    }
}
