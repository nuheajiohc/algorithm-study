import java.util.*;
import java.io.*;

public class Main {
    private static int[][] dp,route; 
    private static int M,N;
    private static int[] dx = {0,0,1,-1};
    private static int[] dy = {1,-1,0,0};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        route = new int[M][N];
        dp = new int[M][N];
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                route[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j]=-1;
            }
        }
        System.out.println(dfs(0,0));
    }

    public static int dfs(int x, int y){
        if(x==M-1 && y==N-1) return 1;
        if(dp[x][y]!=-1){
            return dp[x][y];
        }else{
            dp[x][y]=0;
            for(int dir=0; dir<4; dir++){
                int nx= x+dx[dir];
                int ny= y+dy[dir];

                if(nx<0 || ny<0 || nx>=M || ny>=N) continue;
                if(route[x][y]>route[nx][ny]) dp[x][y] += dfs(nx,ny);
            }
        }
        return dp[x][y];
    }
}
