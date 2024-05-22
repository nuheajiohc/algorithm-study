import java.io.*;
import java.util.*;

public class Main {

    private static int[] dy = {1,-1};
    private static int N,K;
    private static int[] vis;
    private static int[] move;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        vis = new int[100001];
        move = new int[100001];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(N);
        vis[N]=1;

        int minTime = Integer.MAX_VALUE;
        while(!queue.isEmpty()){
            int cur = queue.poll();
            if(cur == K){
                minTime = vis[cur];
                break;
            }
            if(!(isOutOfRange(cur*2) || vis[cur*2]>0)){
                vis[cur*2] = vis[cur]+1;
                move[cur*2] = 2;
                queue.offer(cur*2);
            }
            for(int i=0; i<2; i++){
                int nx = cur + dy[i];
                if(isOutOfRange(nx)) continue;
                if(vis[nx]>0) continue;
                vis[nx] = vis[cur]+1;
                move[nx] = dy[i];
                queue.offer(nx);
            }
        }

        sb.append(minTime-1).append("\n");
        dfs(K);
        System.out.println(sb.toString());
    }

    public static void dfs(int cur){
        if(move[cur]==2){
            dfs(cur/2);
        }else if(move[cur]==1 || move[cur]==-1){
            dfs(cur+move[cur]*(-1));
        }

        sb.append(cur).append(" ");
        if(cur==N) return;
    }

    public static boolean isOutOfRange(int x){
        return x<0 || x>100000;
    }
}
