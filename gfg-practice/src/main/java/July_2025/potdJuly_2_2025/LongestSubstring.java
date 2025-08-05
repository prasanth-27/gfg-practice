package July_2025.potdJuly_2_2025;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;

public class LongestSubstring {

    public static void main(String[] args) {

        //int[] arr = new int[]{2,1,2};
        //System.out.println(LengthOfLongestSubstringwithAtmost2Digits_2(arr));

       // int[] arr2 = new int[]{3, 1, 2, 2, 2, 2};
       // System.out.println(LengthOfLongestSubstringwithAtmost2Digits_2(arr2));

        int[] arr3 = new int[]{3, 10, 2, 2, 2, 2};
        System.out.println(LengthOfLongestSubstringwithAtmost2Digits_2(arr3));

       int[] arr4 = new int[]{3, 10, 2, 2, 100, 1, 1, 1, 100, 100, 1, 1, 1};
       System.out.println(LengthOfLongestSubstringwithAtmost2Digits_2(arr4));

    }

    // 0<=arr[i]<=10^5
    private static int LengthOfLongestSubstringwithAtmost2Digits_2(int[] arr){
        int n = arr.length;
        int distinct=0,result=0,size=0,i=0,j=0;
        HashMap<Integer,Integer> mp = new HashMap<>();

        while(j<n){

            if(mp.containsKey(arr[j])){
                mp.put(arr[j], mp.get(arr[j])+1);
            }else
            {
                mp.put(arr[j], 1);
            }

            size++;
            if(size>result && mp.size()<=2){
                result=size;
            }

            System.out.println("***********");
            System.out.println(mp.toString());
            System.out.println(size);
            System.out.println(result);
            System.out.println("***********");

            while(mp.size()>2){
                mp.put(arr[i], mp.get(arr[i])-1);
                if(mp.get(arr[i])==0){
                    mp.remove(arr[i]);
                }
                size--;
                System.out.println("++++++++++++");
                System.out.println(mp.toString());
                System.out.println(size);
                System.out.println(result);
                System.out.println("++++++++++++");
                i++;
            }
            j++;
            System.out.println(mp.toString());
            System.out.println(size);
            System.out.println(result);
            System.out.println("-----------");
        }

        return result;
    }


    // works if 0<=arr[i] <=9
    private static int LengthOfLongestSubstringwithAtmost2Digits(int[] arr){
        int n = arr.length;
        int distinct=0,result=0,size=0,i=0,j=0;
        int[] mp = new int[10];

        while(j<n){

            int jcount = mp[arr[j]];
            System.out.println(j);
            System.out.println(arr[j]);
            System.out.println(jcount);
            System.out.println(distinct);
            System.out.println(result);
            System.out.println("---------------");
            if(jcount==0){
                distinct++;
            }
            mp[arr[j]]=jcount+1;

            size++;
            if(size>result && distinct<=2){
                result=size;
            }

            System.out.println(distinct);
            System.out.println(result);
            System.out.println("---------------");

            while(distinct>2){
                int icount = mp[arr[i]];
                if(icount-1 == 0){
                    distinct--;
                }
                mp[arr[i]] = icount-1;
                i++;
                size--;
            }
            j++;
        }

        return result;
    }

}
