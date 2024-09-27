import java.io.*;
import java.util.*;

public class Main {

    private static int[] dx = {0,0,1,-1};
    private static int[] dy = {1,-1,0,0};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while(T-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int[][] board = new int[N][M];
            for(int i=0; i<K; i++){
                st = new StringTokenizer(br.readLine());
                int y = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                board[x][y]=1;
            }

            boolean[][] vis = new boolean[N][M];
            int count=0;  
            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    if(board[i][j]==0 || vis[i][j]) continue;
                    count++;
                    vis[i][j]=true;
                    Deque<Point> queue = new ArrayDeque<>();
                    queue.offer(new Point(i, j));
                    while(!queue.isEmpty()){
                        Point p = queue.poll();
                        for(int dir=0; dir<4; dir++){
                            int nx = p.x+dx[dir];
                            int ny = p.y+dy[dir];
                            if(nx<0|| ny<0 || nx>=N || ny>=M) continue;
                            if(vis[nx][ny]) continue;
                            if(board[nx][ny]==0) continue;
                            vis[nx][ny]=true;
                            queue.offer(new Point(nx,ny));
                        }
                    }
                }
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }

    private static class Point{
        int x;
        int y;

        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
