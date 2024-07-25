import java.io.*;
import java.util.*;

public class Main {
    private static int N,M,K;
    private static int[] weight;
    private static boolean[] vis;
    private static int[] order;
    private static int result= Integer.MAX_VALUE;
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        weight = new int[N];
        vis = new boolean[N];
        order = new int[N];
        
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            weight[i] = Integer.parseInt(st.nextToken());
        }

        check(0);
        System.out.println(result);
    }

    public static void check(int depth){
        if(depth == N){
            int idx=0;
            int total=0;
            for(int i=0; i<K; i++){
                int sum=0;
                while(sum+order[idx]<=M){
                    sum+=order[idx];
                    idx++;
                    idx = idx%N;
                }
                total+=sum;
            }
            result = Math.min(result,total);
            return;
        }

        for(int i=0; i<N; i++){
            if(vis[i]) continue;
            vis[i] = true;
            order[depth] = weight[i];
            check(depth+1);
            vis[i] = false;
        }
    }
}
