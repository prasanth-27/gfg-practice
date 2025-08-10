package August_2025.potdAug_06_2025;

public class potdAug_06_2025 {
    public static void main(String[] args) {
        String s = "IX";
        System.out.println(romanNumberToInt(s));

        s = "XL";
        System.out.println(romanNumberToInt(s));

        s = "MCMIV";
        System.out.println(romanNumberToInt(s));

        s = "VVIII";
        System.out.println(romanNumberToInt(s));
    }

    private static int romanNumberToInt(String s){
        int n = s.length();
        int num=getIntFormRoman(s.charAt(n-1));

        for(int i =n-2; i>=0;i--){
            if(getIntFormRoman(s.charAt(i))< getIntFormRoman(s.charAt(i+1))){
                num-=getIntFormRoman(s.charAt(i));
            }else{
                num+=getIntFormRoman(s.charAt(i));
            }
        }
        return num;
    }

    private static int getIntFormRoman(char ch){

        switch (ch){
            case 'I' : return 1;
            case 'V' : return 5;
            case 'X' : return 10;
            case 'L' : return 50;
            case 'C' : return 100;
            case 'D' : return 500;
            case 'M' : return 1000;
            default: return 0;
        }
    }
}
