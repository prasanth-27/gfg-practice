package July_2025.potdJuly_17_2025;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class potdJuly_14_2025 {

    public static void main(String[] args) {

        int n=10;
        int k=9;

        System.out.println(maxPowerof(k,n));

        n=5;
        k=30;
        System.out.println(maxPowerof(k,n));

    }

    private static int maxPowerof(int k , int n){
        int ans=n;

        ArrayList<int[]> primeFactors = factorize(k);

        primeFactors.stream().map(Arrays::toString).forEach(System.out::println);

        for(int[] factor: primeFactors){
            int prime = factor[0];
            int power = factor[1];

            int count = legender(n, prime);

            System.out.println(count);

            ans = Math.min(ans, (int)count/power);
        }


        return ans;
    }

    private static ArrayList<int[]> factorize(int n){

        ArrayList<int[]> factors = new ArrayList<>();
        int count = 0;

        while(n%2==0){
            n/=2;
            count++;
        }
        if(count > 0){
            factors.add(new int[]{2,count});
        }

        for(int i=3;i*i<=n;i+=2){
            count=0;
            while(n%i==0){
                n/=i;
                count++;
            }
            if(count > 0){
                factors.add(new int[]{i,count});
            }

        }

        if(n>1){ // this represents the remaining n is prime number
            factors.add(new int[]{n,1});
        }

        return factors;
    }

    private static int legender(int n , int p){
        int count=0;
        int base=p;
        while(base<=n){

           // System.out.println(base);
            count +=(int)(n/base);
            base*=p;
        }

        return count;
    }
}
