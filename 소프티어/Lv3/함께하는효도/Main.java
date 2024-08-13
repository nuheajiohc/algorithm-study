import java.io.*;
import java.util.*;

public class Main {

    private static int n,m, maxValue;
    private static int[][] board;
    private static int[][] vis;
    private static int[] dx = {0,1,-1,0};
    private static int[] dy = {1,0,0,-1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n+1][n+1];
        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=n; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        vis = new int[n+1][n+1];
        for(int i=1; i<=m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            vis[a][b] = i;
        }

        int[] pos = getStartPosition(1);
        go(pos[0],pos[1],board[pos[0]][pos[1]], 1,1);
        System.out.println(maxValue);
    }

    public static void go(int x, int y, int value, int count, int order){        
        if(count==4){
            if(order==m){
                maxValue = Math.max(maxValue, value);
                return;
            }
            int[] pos = getStartPosition(order+1);
            go(pos[0],pos[1], value+board[pos[0]][pos[1]],1,order+1);
            return;
        }
        
        for(int dir=0; dir<4; dir++){
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if(isOutOfRange(nx,ny)) continue;
            if(vis[nx][ny]>0) continue;
            vis[nx][ny]=order;
            go(nx,ny,value+board[nx][ny],count+1, order);
            vis[nx][ny]=0;
        }
    }
    

    public static int[] getStartPosition(int order){
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(vis[i][j]==order){
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }

    public static boolean isOutOfRange(int x, int y){
        return x<=0 || x>n || y<=0 || y>n;
    }
}