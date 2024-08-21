import java.io.*;
import java.util.*;

public class Main {

    private static int n;
    private static int[][] board;
    private static boolean[][] vis;
    private static int[] dx = {0,1};
    private static int[] dy = {1,0};
    private static int maxBeauty;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        vis = new boolean[n][n];
        board = new int[n][n];
        for(int i =0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        DFS(0,0,0);
        
        System.out.println(maxBeauty);
    }

    public static void DFS(int pairCount, int start, int currentBeauty){
        if(pairCount == 4){
            maxBeauty = Math.max(maxBeauty, currentBeauty);
            return;
        }

        for(int i=start; i<n*n; i++){
            int x = i/n;
            int y = i%n;
            if(vis[x][y]) continue;
            vis[x][y]=true;
            currentBeauty+=board[x][y];
            for(int dir=0; dir<2; dir++){
                int nx = x+dx[dir];
                int ny = y+dy[dir];
                if(isOutOfRange(nx,ny))continue;
                if(vis[nx][ny]) continue;
                vis[nx][ny]=true;
                DFS(pairCount+1,i+1, currentBeauty+board[nx][ny]);
                vis[nx][ny]=false;
            }
            currentBeauty-=board[x][y];
            vis[x][y]=false;
        }
        
        maxBeauty = Math.max(maxBeauty, currentBeauty);
    }

    public static boolean isOutOfRange(int x, int y){
        return x<0 || x>=n || y<0 || y>=n;
    }
}
