package September_2025.potdSept_16_2025;

import java.util.Stack;

public class potdSept_16_2025 {

    public static void main(String[] args) {
        String[] arr = new String[]{"2", "3", "^", "1", "+"};

        System.out.println(evaluatePostfix(arr));

        arr = new String[]{"2", "3", "1", "*", "+", "9", "-"};
        System.out.println(evaluatePostfix(arr));
    }

    private static int evaluatePostfix(String[] arr){
        Stack<Integer> st = new Stack<>();
        for(String s : arr){
            if(s=="+" || s=="-" || s=="/" || s=="*" || s=="^"){
                int b = st.pop();
                int a = st.pop();
                switch (s){
                    case "+": st.push(a+b); break;
                    case "-": st.push(a-b); break;
                    case "*": st.push(a*b); break;
                    case "/":
                        if (a * b < 0 && a % b != 0)
                            st.push( (a / b) - 1);
                        else st.push(a / b);
                        break;
                    case "^": st.push((int)Math.pow(a,b));
                }

            }else{
                st.push(Integer.parseInt(s));
            }
        }

        return st.pop();
    }
}
