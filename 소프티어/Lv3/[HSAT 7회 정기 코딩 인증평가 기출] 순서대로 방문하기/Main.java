import java.io.*;
import java.util.*;

public class Main {

    private static int n,m;
    private static int[][] board;
    private static boolean[][] vis;
    private static int[][] order;
    private static int count;
    private static int[] dx = {0,1,0,-1};
    private static int[] dy = {1,0,-1,0};
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        vis = new boolean[n+1][n+1];
        board = new int[n+1][n+1];
        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=n; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int temp =2;
        int fx=0;
        int fy=0;
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            board[x][y] =  temp;
            if(board[x][y]==2){
                fx = x;
                fy = y;
            }
            temp++;
        }

        vis[fx][fy]=true;
        go(fx,fy,3);
        System.out.println(count);
    }

    public static void go(int x, int y, int idx){
        if(idx==m+2 && board[x][y]==idx-1){
            count++;
            return;
        }
        
        for(int dir=0; dir<4; dir++){
            int nx = x+dx[dir];
            int ny = y+dy[dir];
            if(isOutOfRange(nx,ny))continue;
            if(vis[nx][ny])continue;
            if(board[nx][ny]==1) continue;
            if(board[nx][ny]>1 && board[nx][ny]!=idx) continue;
            vis[nx][ny]=true;
            if(board[nx][ny]==idx){
                go(nx,ny,idx+1);
            }else{
                go(nx,ny,idx);
            }
            vis[nx][ny]=false;
        }
    }

    public static boolean isOutOfRange(int x, int y){
        return x<=0 || x>n || y<=0 || y>n;
    }
}