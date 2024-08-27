import java.io.*;
import java.util.*;

public class Main {

    private static int N,M;
    private static int[][] grid;
    private static boolean[][] vis;
    private static final int OUTER = 3;
    private static final int INNER = 2;
    private static final int ICE = 1;
    private static int[] dx = {0,1,-1,0};
    private static int[] dy = {1,0,0,-1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        grid = new int[N][M];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int hour = 0;
        while(existsIce()){
            hour+=1;
            meltIce();
        }

        System.out.println(hour);
    }

    public static boolean existsIce(){
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(grid[i][j]==ICE) return true;
            }
        }
        return false;
    }

    public static void meltIce(){
        vis = new boolean[N][M];
        vis[0][0] = true;
        Queue<Point> queue = new ArrayDeque<>();
        queue.offer(new Point(0,0));
        while(!queue.isEmpty()){
            Point point = queue.poll();
            for(int dir=0; dir<4; dir++){
                int nx = point.x+dx[dir];
                int ny = point.y+dy[dir];
                if(isOutOfRange(nx,ny)) continue;
                if(vis[nx][ny]) continue;
                if(grid[nx][ny]==ICE) continue; 
                vis[nx][ny]=true;
                grid[nx][ny]=OUTER;
                queue.offer(new Point(nx,ny));
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(vis[i][j] || grid[i][j]!=INNER) continue;
                vis[i][j]=true;
                queue.offer(new Point(i,j));
                while(!queue.isEmpty()){
                    Point point = queue.poll();
                    for(int dir=0; dir<4; dir++){
                        int nx = point.x + dx[dir];
                        int ny = point.y + dy[dir];
                        if(isOutOfRange(nx,ny)) continue;
                        if(vis[nx][ny]) continue;
                        if(grid[nx][ny]==ICE) continue; 
                        vis[nx][ny]=true;
                        grid[nx][ny]=INNER;
                        queue.offer(new Point(nx,ny));
                    }
                }
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(vis[i][j] || grid[i][j]!=ICE) continue;
                vis[i][j] = true;
                if(canMeltIce(i,j)){
                    queue.offer(new Point(i,j));
                }
            }
        }

        while(!queue.isEmpty()){
            Point point = queue.poll();
            grid[point.x][point.y]=OUTER;
        }
    }

    public static boolean isOutOfRange(int x, int y){
        return x<0 || x>=N || y<0 || y>=M;
    }

    public static boolean canMeltIce(int x, int y){
        int count=0;
        for(int dir=0; dir<4; dir++){
            int nx = x+dx[dir];
            int ny = y+dy[dir];
            if(grid[nx][ny]==OUTER) count++;
        }

        if(count>=2) return true;
        return false;
    }

    public static class Point{
        int x;
        int y;

        public Point(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
}
