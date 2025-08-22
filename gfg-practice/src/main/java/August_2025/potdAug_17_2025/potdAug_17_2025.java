package August_2025.potdAug_17_2025;

import java.util.Arrays;

public class potdAug_17_2025 {
    public static void main(String[] args) {
        int[] arr = new int[]{10, 5, 3, 9, 2};
        int x = 7;
        System.out.println(Arrays.toString(arr));
        rearrage(arr,x);
        System.out.println(Arrays.toString(arr));
    }

    private static void rearrage(int[] arr, int x){
        Integer[] temp = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(temp, ( a, b)-> Math.abs(a-x)-Math.abs(b-x));

        for(int i=0;i<arr.length;i++){
            arr[i] = temp[i];
        }
    }
}
