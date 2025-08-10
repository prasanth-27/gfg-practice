package August_2025.potdAug_07_2025;

public class potdAug_07_2025 {
    public static void main(String[] args) {
        String[] arr = new String[]{"00:00:01", "23:59:59", "00:00:05"};
        System.out.println(minDiff(arr));
    }

    private static int minDiff(String[] arr){
        int n = arr.length;
        int ans=Integer.MAX_VALUE;
        int first=-1,prev=-1,last=-1;

        boolean[] secondsMap = new boolean[86400];

        for(int i=0;i<n;i++){
            int sec = getSeconds(arr[i]);
            if(secondsMap[sec]){
                return 0;
            }
            secondsMap[sec] = true;
        }

        for(int i=0;i<86400;i++){

            if(!secondsMap[i]) continue;

            if(prev !=-1){
                ans=Math.min(ans, i-prev);
            }else{
                first=i;
            }

            prev=i;
            last=i;
        }

        int wrapCheck = first-last+86400;

        return Math.min(ans, wrapCheck);
    }

    private static int getSeconds(String s){
        int h = Integer.parseInt(s.substring(0,2));
        int m = Integer.parseInt(s.substring(3,5));
        int se = Integer.parseInt(s.substring(6));

        return (h*3600)+(m*60)+(se);
    }
}
