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

        int[][] maze = new int[N][M];
        for(int i=0; i<N; i++){
            String line = br.readLine();
            for(int j=0; j<M; j++){
                if(line.charAt(j)=='1'){
                    maze[i][j] = 1;
                }else{
                    maze[i][j] = 0;
                }
            }
        }

        int[][] vis = new int[N][M];
        vis[0][0]=1;
        Deque<Point> queue = new ArrayDeque<>();
        queue.offer(new Point(0,0));
        while(!queue.isEmpty()){
            Point p = queue.poll();
            for(int dir=0; dir<4; dir++){
                int nx = p.x+dx[dir];
                int ny = p.y+dy[dir];
                if(isOutOfRange(nx,ny)) continue;
                if(vis[nx][ny]>0 || maze[nx][ny]==0) continue;
                vis[nx][ny]= vis[p.x][p.y]+1;
                queue.offer(new Point(nx,ny));
            }
        }
        System.out.println(vis[N-1][M-1]);
    }

    public static boolean isOutOfRange(int x, int y){
        return x<0 || y<0 || x>=N || y>=M;
    }

    public static class Point{
        int x;
        int y;
        Point(int x, int y){
            this.x =x;
            this.y =y;
        }
    }
}
