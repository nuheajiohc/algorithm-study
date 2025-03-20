import java.io.*;
import java.util.*;

public class Main {

    private static int N,M;
    private static int[][] board;
    private static int[] dx = {1,-1,0,0};
    private static int[] dy = {0,0,1,-1};
    private static boolean[][] vis;
    private static int max;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        vis = new boolean[N][M];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                backtracking(i,j,board[i][j],1);
                checkUnique(i,j);
            }
        }

        System.out.println(max);
    }

    public static void backtracking(int x, int y, int sum,int count){
        vis[x][y]=true;

        if(count==4){
            max = Math.max(max, sum);
            return;
        }

        for(int dir=0; dir<3; dir++){
            int nx = x+dx[dir];
            int ny = y+dy[dir];
            if(nx<0 || ny<0 || nx>=N || ny>=M) continue;
            if(vis[nx][ny]) continue;
            backtracking(nx,ny,sum+board[nx][ny],count+1);
            vis[nx][ny]=false;
        }
        vis[x][y]=false;
    }

    public static void checkUnique(int x, int y){
        int sum=board[x][y];
        int min=1000;
        int edge=0;

        for(int dir=0; dir<4; dir++){
            int nx = x+dx[dir];
            int ny = y+dy[dir];
            if(nx<0 || ny<0 || nx>=N || ny>=M){
                edge++;
                continue;
            }
            sum+=board[nx][ny];
            min = Math.min(min, board[nx][ny]);
        }

        if(edge==2) return;

        if(edge==1){
            max = Math.max(max, sum);
        }else{
            max = Math.max(max, sum-min);
        }
    }
}
