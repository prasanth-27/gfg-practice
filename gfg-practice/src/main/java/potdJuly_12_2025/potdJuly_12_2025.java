package potdJuly_12_2025;

public class potdJuly_12_2025 {

    public static void main(String[] args) {

        int n =2;

        System.out.println(trailof1s(n));

        n=3;
        System.out.println(trailof1s(n));

        n=4;
        System.out.println(trailof1s(n));

        n=5;
        System.out.println(trailof1s(n));
    }

    private static int trailof1s(int n){

        if(n==2){
            return 1;
        }

        int res=1;
        int first =0;
        int second=1;

        int next=0;

        for(int i=3;i<=n;i++){
            next=first+second;
            res=(res*2)+next;
            first=second;
            second=next;
        }

        return res;
    }
}
