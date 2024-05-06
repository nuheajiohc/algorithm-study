import java.io.*;
import java.util.*;

public class Main {

    private static int N;
    private static List<Integer>[] arr;
    private static int[][] result;
    private static boolean[] vis;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new ArrayList[N+1];
        result = new int[N+1][N+1];

        for(int i=1; i<=N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i] = new ArrayList<>();
            for(int j=1; j<=N; j++){
                int num = Integer.parseInt(st.nextToken());
                if(num == 1){
                    arr[i].add(j);
                }
            }
        }

        for(int i=1; i<=N; i++){
            vis = new boolean[N+1];
            dfs(i,i);
        }

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                sb.append(result[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    public static void dfs(int start, int cur){
        vis[cur]=true;
        for(int next: arr[cur]){
            if(start == next) result[start][next]=1;
            if(vis[next]) continue;
            result[start][next]=1;
            dfs(start, next);
        }
    }
}
