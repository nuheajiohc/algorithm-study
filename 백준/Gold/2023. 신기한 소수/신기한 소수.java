import java.io.*;
import java.util.*;

public class Main {

    private static int N;
    private static int[] arr;
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[N];

        findPrimeNumber(0);
        System.out.println(sb);
    }

    public static void findPrimeNumber(int depth){
        if(depth==N){
            int number = convertToNumber();
            sb.append(number).append("\n");
            return;
        }

        for(int i=1; i<10; i++){
            arr[depth] = i;
            int number = convertToNumber(depth);
            if(!isPrimeNumber(number)) continue;
            findPrimeNumber(depth+1);
        }
    }

    public static boolean isPrimeNumber(int number){
        if(number ==1) return false;
        if(number!=2 && number%2==0) return false;
        for(int i=2; i*i<=number; i++){
            if(number%i==0) return false;
        }
        return true;
    }


    public static int convertToNumber(){
        int number=0;
        for(int i=0; i<N; i++){
            number = number*10+arr[i];
        }
        return number;
    }

    public static int convertToNumber(int depth){
        if(depth==0){
            return arr[depth]; 
        }
        return arr[depth]+10*convertToNumber(depth-1);
    }
}
