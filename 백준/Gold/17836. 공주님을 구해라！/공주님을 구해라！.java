import java.io.*;
import java.util.*;

public class Main {

    private static int N,M,T;
    private static int[][] board;
    private static int[][] vis;
    private static boolean getSword=false;
    private static Point swordPos;
    private static int[] dx = {0,0,1,-1};
    private static int[] dy = {1,-1,0,0};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        vis = new int[N][M];
        for(int[] row : vis){
            Arrays.fill(row, -1);
        }

        board = new int[N][M];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j]==2){
                    swordPos = new Point(i,j);
                }
            }
        }

        bfs();

        if(getSword){
            int cand = vis[swordPos.x][swordPos.y] + N-1-swordPos.x + M-1-swordPos.y;
            if(vis[N-1][M-1]==-1){
                if(cand<=T){
                    System.out.println(cand);
                }else{
                    System.out.println("Fail");
                }
            }else{
                int minimum = Math.min(cand, vis[N-1][M-1]);
                if(minimum<=T){
                    System.out.println(minimum);
                }else{
                    System.out.println("Fail");
                }
            }
        }else{
            if(vis[N-1][M-1]==-1 || vis[N-1][M-1]>T){
                System.out.println("Fail");
            }else{
                System.out.println(vis[N-1][M-1]);
            }
        }
        

    }

    public static void bfs(){
        Queue<Point> q = new ArrayDeque<>();
        q.offer(new Point(0,0));
        vis[0][0] = 0;

        while(!q.isEmpty()){
            Point p = q.poll();
            for(int dir=0; dir<4; dir++){
                int nx = p.x+dx[dir];
                int ny = p.y+dy[dir];
                if(nx<0 || ny<0 || nx>=N || ny >=M) continue;
                if(vis[nx][ny]!=-1) continue;
                if(board[nx][ny]==1) continue;
                if(nx == swordPos.x && ny == swordPos.y){
                    getSword = true;
                }
                vis[nx][ny]= vis[p.x][p.y]+1;
                q.offer(new Point(nx,ny));
            }
        }
    }

    public static class Point{
        int x;
        int y;

        Point(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
}
