import java.io.*;
import java.util.*;

public class Main {

    private static int N,M;
    private static int[] arr;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        backtracking(0);
        System.out.println(sb.toString());
    }

    public static void backtracking(int depth){
        if(M == depth){
            for(int n : arr){
                sb.append(n).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=1; i<=N; i++){
            arr[depth]=i;
            backtracking(depth+1);
        }
    }
}
