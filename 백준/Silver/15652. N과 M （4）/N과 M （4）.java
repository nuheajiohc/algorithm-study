import java.io.*;
import java.util.*;

public class Main {
    
    private static int N,M;
    private static StringBuilder sb = new StringBuilder();
    private static int[] arr;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr =new int[M];
        backtracking(1,0);
        System.out.println(sb.toString());
    }

    public static void backtracking(int k, int depth){
        if(depth == M){
            for(int n : arr){
                sb.append(n).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=k; i<=N; i++){
            arr[depth] = i;
            backtracking(i,depth+1);
        }
    }
}
