package Feb_2026;

public class Potd_Feb_18 {

    public static void main(String[] args) {
        int[] arr = new int[]{2,4,1,3,5};
        System.out.println(inversionCount(arr));
    }
    
    static int countInversionBrute(int[] arr){
        int ans=0;
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i]>arr[j]) 
                    ans++;
            }
        }
        return ans;
    }

    static int countInversions(int[] arr, int l, int r){
        int ans=0;

        if(l<r){
            int m=(l+r)/2;
            ans+=countInversions(arr,l,m);
            ans+=countInversions(arr,m+1,r);

            ans+=countAndMerge(arr,l,r,m);

        }

        return ans;
    }

    private static int countAndMerge(int[] arr, int l, int r, int m) {
        int count=0;
        int i=0,j=0,k=l;

        int s1=m-l+1, s2=r-m;

        int[] left = new int[s1];
        int[] right = new int[s2];

        for(int idx=0;idx<s1;idx++){
            left[idx] = arr[idx+l];
        }
        for(int idx=0;idx<s2;idx++){
            right[idx] = arr[m+1+idx];
        }

        while(i<s1 && j<s2){
            if(left[i]>right[j]){
                count+=(s1-i);
                arr[k]=right[j];
                k++;
                j++;
            }else{
                arr[k]=left[i];
                k++;
                i++;
            }
        }

        while(i<s1){
            arr[k++]=left[i++];
        }
        while(j<s2){
            arr[k++]=right[j++];
        }

        return count;
    }

    static int inversionCount( int[] arr ) {
        // Code Here

        return countInversions(arr,0,arr.length-1);
    }
}
