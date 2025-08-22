package August_2025.potdAug_18_2025;

public class potdAug_18_2025 {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 0, 5, 3, 0};
        System.out.println(hIndex(arr));
    }

    private static int hIndex(int[] citations){
        int n = citations.length;

        int[] freq = new int[n+1];

        for(int i=0;i<n;i++){
            if(citations[i]>n)
                freq[n]++;
            else
                freq[citations[i]]++;
        }

        int s = freq[n];
        int idx=n;
        while(s<idx){
            idx--;
            s+=freq[idx];
        }
        return idx;
    }
}
