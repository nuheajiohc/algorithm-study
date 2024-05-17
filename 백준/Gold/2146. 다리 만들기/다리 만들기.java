import java.io.*;
import java.util.*;

public class Main {

    private static int[] dx = {0,1,-1,0};
    private static int[] dy = {1,0,0,-1};
    private static int[][] country;
    private static int N;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        country = new int[N][N];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                country[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        separateIslands();

        int minBridgeLength=10000;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(country[i][j]==0) continue;
                if(isInnerArea(i,j)) continue;

                minBridgeLength = Math.min(minBridgeLength, bfs(i,j));
            }
        }
        System.out.println(minBridgeLength);
    }

    public static boolean isInnerArea(int x, int y){
        for(int dir=0; dir<4; dir++){
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if(isOutOfRange(nx,ny)) continue;
            if(country[nx][ny]==0) return false;
        }
        return true;
    }

    public static int bfs(int x, int y){
        int[][] vis = new int[N][N];
        int curIsland = country[x][y];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{x,y});
        
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            for(int dir=0; dir<4; dir++){
                int nx = cur[0]+dx[dir];
                int ny = cur[1]+dy[dir];
                if(isOutOfRange(nx,ny)) continue;
                if(country[nx][ny]==curIsland) continue;
                if(vis[nx][ny]>0) continue;
                vis[nx][ny] = vis[cur[0]][cur[1]]+1;
                if(country[nx][ny]!=0 && country[nx][ny]!=curIsland){
                    return vis[nx][ny]-1;
                }
                queue.offer(new int[]{nx,ny});
            }
        }
        return Integer.MAX_VALUE;
    }

    public static void separateIslands(){
        boolean[][] vis = new boolean[N][N];
        int number=0;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(vis[i][j] || country[i][j]==0) continue;
                number++;

                Queue<int[]> queue = new ArrayDeque<>();
                queue.offer(new int[]{i,j});
                vis[i][j] = true;
                country[i][j] = number;
                while(!queue.isEmpty()){
                    int[] cur = queue.poll();
                    for(int dir=0; dir<4; dir++){
                        int nx = cur[0]+dx[dir];
                        int ny = cur[1]+dy[dir];
                        if(isOutOfRange(nx,ny)) continue;
                        if(vis[nx][ny] || country[nx][ny]==0) continue;
                        queue.offer(new int[]{nx,ny});
                        vis[nx][ny] = true;
                        country[nx][ny] = number;
                    }
                }
            }
        }
    }

    public static boolean isOutOfRange(int x, int y){
        return x<0 || x>=N || y<0 || y>=N;
    }
}
