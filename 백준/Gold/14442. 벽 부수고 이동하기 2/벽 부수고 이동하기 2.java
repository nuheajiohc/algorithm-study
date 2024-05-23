import java.io.*;
import java.util.*;

public class Main {

    private static int[] dx = {1,0,-1,0};
    private static int[] dy = {0,1,0,-1};
    private static int[][] map;
    private static int N,M,K;
    private static int[][][] vis;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        map = new int[N][M];
        for(int i=0; i<N; i++){
            String line = br.readLine();
            for(int j=0; j<M; j++){
                map[i][j] = line.charAt(j)-'0';
            }
        }

        vis = new int[N][M][K+1];
        bfs();
        
        int minDistance = Integer.MAX_VALUE;
        for(int i=0; i<=K; i++){
            if(vis[N-1][M-1][i]==0) continue;
            minDistance = Math.min(minDistance,vis[N-1][M-1][i]);
        }
        
        if(minDistance==Integer.MAX_VALUE){
            System.out.println(-1);
        }else{
            System.out.println(minDistance);
        }
    }

    public static void bfs(){
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0,0,0});
        vis[0][0][0] = 1;

        while(!queue.isEmpty()){
            int[] cur=queue.poll();
            for(int dir=0; dir<4; dir++){
                int nx = cur[0]+dx[dir];
                int ny = cur[1]+dy[dir];
                if(isOutOfRange(nx,ny)) continue;
                if(map[nx][ny]==0 && vis[nx][ny][cur[2]]==0){
                    queue.offer(new int[]{nx,ny,cur[2]});
                    vis[nx][ny][cur[2]] = vis[cur[0]][cur[1]][cur[2]]+1;
                }
                if(map[nx][ny]==1 && cur[2]<K && vis[nx][ny][cur[2]+1]==0){
                    queue.offer(new int[]{nx,ny,cur[2]+1});
                    vis[nx][ny][cur[2]+1] = vis[cur[0]][cur[1]][cur[2]]+1;
                }
            }
        }
    }

    public static boolean isOutOfRange(int x, int y){
        return x<0 || x>=N || y<0 || y>=M;
    }
}