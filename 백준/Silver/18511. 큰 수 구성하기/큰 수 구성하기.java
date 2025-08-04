import java.io.*;
import java.util.*;

public class Main {

    private static int N,K,size;
    private static int[] arr;
    private static int answer=0;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        size = String.valueOf(N).length();

        st = new StringTokenizer(br.readLine());
        arr = new int[K];
        for(int i=0; i<K; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        check(0,0);
        System.out.println(answer);
    }

    public static void check(int k, int result){
        if(result<=N){
            answer = Math.max(answer, result);
        }
        if(k==size){
            
            return;
        }

        for(int i=0; i<K; i++){
            check(k+1, result*10+arr[i]);
        }
    }
}
