import java.io.*;
import java.util.*;

public class Main {

    private static int N,M;
    private static int[] arr,res;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        res = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        backtracking(0);
        System.out.println(sb.toString());
    }

    public static void backtracking(int depth){
        if(depth == M){
            for(int n : res){
                sb.append(n).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=0; i<N;i++){
            res[depth] = arr[i];
            backtracking(depth+1);
        }
    }
}
