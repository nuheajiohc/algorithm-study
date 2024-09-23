import java.io.*;

public class Main {

    private static int N;
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        findPrimeNumber(0,0);
        System.out.println(sb);
    }

    public static void findPrimeNumber(int depth, int number){
        if(depth == N){
            sb.append(number).append("\n");
            return;
        }

        for(int i=1; i<10; i++){
            int curNumber = number*10 + i;
            if(isPrimeNumber(curNumber)) findPrimeNumber(depth+1, curNumber);
        }
    }

    public static boolean isPrimeNumber(int number){
        if(number==1) return false;
        if(number==2) return true;
        if(number%2==0) return false;
        for(int i=3; i*i<=number; i+=2){
            if(number%i==0) return false;
        }
        return true;
    }
}   
