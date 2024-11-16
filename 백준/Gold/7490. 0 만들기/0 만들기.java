import java.io.*;

public class Main {

    private static int[] arr;
    private static String[] oper;
    private static int N;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while(T-->0){
            N = Integer.parseInt(br.readLine());
            arr = new int[N];
            oper = new String[N];
            for(int i = 0; i < N; i++){
                arr[i] = i+1;
            }
            check(1,String.valueOf(arr[0]));
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void check(int depth, String str){
        if(depth== N){
            int sum=calculateSum(str);
            if(sum==0) sb.append(str).append("\n");
            return;
        }
        oper[depth]=" ";
        check(depth+1, str+" "+arr[depth]);

        oper[depth]="+";
        check(depth+1, str+"+"+arr[depth]);

        oper[depth]="-";
        check(depth+1, str+"-"+arr[depth]);
    }

    public static int calculateSum(String expression){
        int sum=0;
        expression = expression.replaceAll(" ", "");
        int temp = 0;
        char sign = '+';

        for(int i=0; i<expression.length(); i++){
            char c = expression.charAt(i);

            if(Character.isDigit(c)){
                temp = temp*10 + (c-'0');
            }

            if(i==expression.length()-1 || isOperator(c) ){
                if(sign == '+'){
                    sum+=temp;
                } else if(sign == '-'){
                    sum-=temp;
                }
                sign=c;
                temp=0;
            }
        }
        return sum;
    }

    private static boolean isOperator(char c){
        return c=='+' || c=='-';
    }
}
