import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[][] maze;
    static int[] dx = {0, 0, 1, -1}, dy = {1, -1, 0, 0};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        maze = new int[N][M];
        for(int i=0; i<N; i++){
            String line = br.readLine();
            for(int j=0; j<M; j++){
                maze[i][j] = (line.charAt(j)-'0') -1;
            }
        }

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, 0});
        maze[0][0] = 1;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            for(int dir=0; dir<4; dir++){
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                if(nx<0 || nx>=N || ny<0 || ny>=M) continue;
                if(maze[nx][ny]!=0) continue;
                maze[nx][ny] = maze[x][y] + 1;
                q.offer(new int[]{nx, ny});
            }
        }

        System.out.println(maze[N-1][M-1]);

    }
}
