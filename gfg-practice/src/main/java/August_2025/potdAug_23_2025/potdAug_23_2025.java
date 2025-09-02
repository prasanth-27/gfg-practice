package August_2025.potdAug_23_2025;

import java.util.Arrays;

public class potdAug_23_2025 {
    public static void main(String[] args) {
        int[] arr = {12, 34, 67, 90};
        int k = 2;
        System.out.println(findPages(arr, k));
    }

    private static int findPages(int[] arr, int k){

        if(k>arr.length) return -1;

        int lo = Arrays.stream(arr).max().getAsInt();
        int hi = Arrays.stream(arr).sum();

        int res=-1;

        while(lo <= hi){
            int mid = lo+ (hi-lo)/2;

            //If split is possible mark as answer and check in lower half to see if we can find better ans.
            if(splitPossible(arr,mid,k)){
                res=mid;
                hi = mid-1;
            }else{//else check in the higher range for ans.
                lo = mid+1;
            }
        }

        return res;
    }

    //check for the identified pagelimit if we can split books among k students.
    //we keep assigning books to a student untill adding another boo exceeds page limit,
    //then we assign that bbok to next and keep assigning to new student untill reaches limit
    //and so on
    //finally check if count <=k,... because if lessthan k students can be assigned books then they can be redistributed among k students and minimize the max pages.
    private static boolean splitPossible(int[] arr, int pageLimit, int k){
        int n = arr.length;
        int count=1;
        int pageSum=0;

        for(int i =0;i<n;i++) {
            if (pageSum + arr[i] > pageLimit){
                count++;
                pageSum = arr[i];
            }else{
                pageSum+=arr[i];
            }
        }
        return count<=k;
    }
}
