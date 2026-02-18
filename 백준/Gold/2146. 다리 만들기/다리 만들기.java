import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] map, dist;
    static int[] dx = {0, 0, 1, -1}, dy = {1, -1, 0, 0};
    static Queue<int[]> cand = new ArrayDeque<>();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        dist = new int[N][N];
        map = new int[N][N];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        divideIslands();
        findCandidate();
        int minLen = findMinLen();
        System.out.println(minLen);
    }

    static int findMinLen(){
        int minDist = Integer.MAX_VALUE;

        while(!cand.isEmpty()){
            int[] cur = cand.poll();
            int x = cur[0];
            int y = cur[1];
            int country = map[x][y];

            for(int dir=0; dir<4; dir++){
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                if(isOutOfRange(nx ,ny)) continue;
                if(map[nx][ny]==country) continue;
                if(map[nx][ny]==0 && dist[nx][ny]==0){
                    map[nx][ny] = map[x][y];
                    cand.offer(new int[]{nx, ny});
                    dist[nx][ny] = dist[x][y] + 1;
                }else{
                    minDist = Math.min(minDist, dist[x][y] + dist[nx][ny]);
                }
            }
        }
        return minDist;
    }

    static void findCandidate(){
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(map[i][j]==0) continue;
                if(isInsideArea(i, j)) continue;
                cand.offer(new int[]{i, j});

            }
        }
    }

    static void divideIslands(){
        boolean[][] visited = new boolean[N][N];
        int unique = 0;
        Queue<int[]> queue = new ArrayDeque<>();
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(map[i][j]==0 || visited[i][j]) continue;
                unique++;
                visited[i][j] = true;
                map[i][j] = unique;
                queue.offer(new int[]{i,j});
                while(!queue.isEmpty()){
                    int[] cur = queue.poll();
                    for(int dir=0; dir<4; dir++){
                        int nx = cur[0] + dx[dir];
                        int ny = cur[1] + dy[dir];
                        if(isOutOfRange(nx ,ny)) continue;
                        if(visited[nx][ny] || map[nx][ny]==0) continue;
                        visited[nx][ny] = true;
                        map[nx][ny] = unique;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }

        }
    }

    static boolean isInsideArea(int x, int y){
        for(int dir=0; dir<4; dir++){
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if(isOutOfRange(nx, ny)) continue;
            if(map[nx][ny]==0) return false;
        }
        return true;
    }

    static boolean isOutOfRange(int x, int y){
        return x<0 || x>=N || y<0 || y>=N;
    }
}
