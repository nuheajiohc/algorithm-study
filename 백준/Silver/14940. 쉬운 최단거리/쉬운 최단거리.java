import java.io.*;
import java.util.*;

public class Main {

    private static int N,M;
    private static int[] dx = {0,0,1,-1};
    private static int[] dy = {1,-1,0,0};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        Queue<Point> q = new ArrayDeque<>();
        int[][] vis = new int[N][M];
        int[][] board = new int[N][M];
        Point target = null;

        for(int i=0; i<N; i++){
            Arrays.fill(vis[i],-1);
        }

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j]==2){
                    target = new Point(i,j);
                    q.offer(target);
                    vis[i][j]=0;
                }
            }
        }

        while(!q.isEmpty()){
            Point p = q.poll();
            for(int dir=0; dir<4; dir++){
                int nx = p.x+dx[dir];
                int ny = p.y+dy[dir];
                if(isOutOfRange(nx,ny)) continue;
                if(nx==target.x && ny ==target.y) continue;
                if(vis[nx][ny]>0 || board[nx][ny]==0) continue;
                vis[nx][ny] = vis[p.x][p.y] + 1;
                q.offer(new Point(nx,ny));
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(vis[i][j]==-1){
                    if(board[i][j]==0){
                        vis[i][j]=0;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                sb.append(vis[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static boolean isOutOfRange(int x, int y){
        return x<0 || x>=N || y<0 || y>=M;
    }

    public static class Point{
        int x;
        int y;

        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
