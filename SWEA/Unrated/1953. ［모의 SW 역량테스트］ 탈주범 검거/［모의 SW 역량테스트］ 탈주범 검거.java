import java.io.*;
import java.util.*;

public class Solution {

    static int N, M, R, C, L;
    static int[][] map = new int[50][50];
    static int[][][] types = {
        {},
        {{0,1}, {1,0}, {0,-1}, {-1,0}},
        {{1,0}, {-1,0}},
        {{0,1}, {0,-1}},
        {{-1,0}, {0,1}},
        {{1,0}, {0,1}},
        {{1,0}, {0,-1}},
        {{-1,0}, {0, -1}}
    };
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=TC; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());

            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<M; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            sb.append("#").append(tc).append(" ").append(bfs()).append("\n");

        }
        System.out.println(sb);
    }

    static int bfs(){
        int cnt = 0;
        int[][] visited = new int[N][M];
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{R, C});
        visited[R][C] = 1;
        cnt++;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0]; int y = cur[1];
            int type = map[x][y];
            for(int[] dir : types[type]){
                int nx = x + dir[0];
                int ny = y + dir[1];
                if(nx<0 || nx>=N || ny<0 || ny>=M) continue;
                if(!moveable(x,y, nx,ny)) continue;
                if(map[nx][ny]==0 || visited[nx][ny]>0) continue;
                if(visited[x][y]+1>L) continue;
                visited[nx][ny] = visited[x][y] + 1;
                cnt++;
                q.offer(new int[]{nx, ny});
            }
        }
        return cnt;
    }

    static boolean moveable(int x, int y, int nx, int ny){
        int type = map[nx][ny];
        for(int[] dir : types[type]){
            if(x==nx+dir[0] && y==ny+dir[1]) return true;
        }
        return false;
    }
}
