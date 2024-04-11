import java.io.*;
import java.util.*;

public class Main {

    private static int N;
    private static int[] dx = {0,0,1,-1};
    private static int[] dy = {1,-1,0,0};
    private static boolean[][] vis;
    private static String[] area;
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        area= new String[N];
        for(int i=0; i<N; i++){
            area[i] = br.readLine();
        }
        bfs();

        for(int i=0; i<N; i++){
            area[i] = area[i].replace("G","R");
        }
        bfs();
        System.out.println(sb.toString());
    }

    public static void bfs(){
        vis = new boolean[N][N];
        int count=0;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(vis[i][j]) continue;
                count++;
                vis[i][j]= true;
                ArrayDeque<int[]> q = new ArrayDeque<>();
                q.offer(new int[] {i,j});
                while(!q.isEmpty()){
                    int[] cur =q.poll();
                    for(int dir=0; dir<4; dir++){
                        int nx = cur[0] + dx[dir];
                        int ny = cur[1] + dy[dir];
                        if(nx<0 || ny<0 || nx>=N || ny>=N) continue;
                        if(vis[nx][ny]) continue;
                        if(area[i].charAt(j)==area[nx].charAt(ny)){
                            q.offer(new int[] {nx,ny});
                            vis[nx][ny] = true;
                        }
                    }
                }
            }
        }
        sb.append(count).append(" ");
    }
}
