import java.io.*;
import java.util.*;

public class Main {

    private static int[] dx = {1,0,-1,0};
    private static int[] dy = {0,1,0,-1};
    private static int N,M,K;
    private static int[][] board;
    private static boolean[][][] vis;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        for(int i=0; i<N; i++){
            String line = br.readLine();
            for(int j=0; j<M; j++){
                board[i][j] = line.charAt(j)-'0';
            }
        }
        vis = new boolean[N][M][K+1];
        
        System.out.println(bfs());
    }

    public static int bfs(){
        Queue<Point> queue = new ArrayDeque<>();
        queue.offer(new Point(0,0,1,0,true));
        vis[0][0][0]=true;
        while(!queue.isEmpty()){
            Point cur = queue.poll();
            if(cur.x==N-1 && cur.y==M-1){
                return cur.count;
            }
            for(int dir=0; dir<4; dir++){
                int nx = cur.x+dx[dir];
                int ny = cur.y+dy[dir];
                if(isOutOfRange(nx,ny)) continue;
                if(board[nx][ny]==0){
                    if(vis[nx][ny][cur.wall]) continue;
                    vis[nx][ny][cur.wall]= true;
                    queue.offer(new Point(nx,ny,cur.count+1,cur.wall,!cur.isDay));
                }else{
                    if(cur.isDay && cur.wall<K){
                        if(vis[nx][ny][cur.wall+1]) continue;
                        vis[nx][ny][cur.wall+1] = true;
                        queue.offer(new Point(nx,ny,cur.count+1, cur.wall+1,!cur.isDay));
                    }else if(!cur.isDay && cur.wall<K){
                        queue.offer(new Point(cur.x, cur.y,cur.count+1, cur.wall,!cur.isDay));
                    }
                }
            }
        }
        return -1;
    }

    public static boolean isOutOfRange(int x, int y){
        return x<0 || x>=N || y<0 || y>=M;
    }

    public static class Point{
        int x;
        int y;
        int count;
        int wall;
        boolean isDay;

        public Point(int x, int y, int count, int wall, boolean isDay){
            this.x = x;
            this.y = y;
            this.count = count;
            this.wall = wall;
            this.isDay = isDay;
        }
    }
}
