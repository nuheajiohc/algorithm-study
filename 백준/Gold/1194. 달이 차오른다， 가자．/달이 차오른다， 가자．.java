import java.io.*;
import java.util.*;

public class Main {

    static int N,M;
    static char[][] maze;
    static int[][][] visited;
    static int[] dx = {0,0,1,-1}, dy = {1,-1,0,0};
    static int[] arrived;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int ix = 0;
        int iy = 0;

        maze = new char[N][M];
        for(int i=0; i<N; i++){
            String line = br.readLine();
            for(int j=0; j<M; j++){
                maze[i][j] = line.charAt(j);
                if(maze[i][j] == '0'){
                    ix = i;
                    iy = j;
                }
            }
        }
        visited = new int[64][N][M];

        bfs(ix, iy);
        if(arrived == null){
            System.out.println(-1);
        }else{
            System.out.println(visited[arrived[0]][arrived[1]][arrived[2]]-1);
        }
    }

    static void bfs(int ix, int iy){
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, ix, iy});
        visited[0][ix][iy] = 1;

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            for(int dir=0; dir<4; dir++){
                int nx = cur[1] + dx[dir];
                int ny = cur[2] + dy[dir];
                int status = cur[0];
                if(nx<0 || nx>=N || ny<0 || ny>=M) continue;
                if(visited[status][nx][ny]>0) continue;
                if(maze[nx][ny]=='#') continue;
                if(maze[nx][ny]>='A'&& maze[nx][ny]<='F'){
                    if((status & 1<<(maze[nx][ny]-'A'))!=0){
                        visited[status][nx][ny] = visited[status][cur[1]][cur[2]]+1;
                        queue.offer(new int[]{status, nx, ny});
                    }
                } else if(maze[nx][ny]>='a' && maze[nx][ny]<='f'){
                    int nStatus = status | 1<<(maze[nx][ny]-'a');
                    visited[nStatus][nx][ny] = visited[status][cur[1]][cur[2]] + 1;
                    queue.offer(new int[]{nStatus, nx, ny});
                } else{
                    visited[status][nx][ny] = visited[status][cur[1]][cur[2]]+1;
                    queue.offer(new int[]{status, nx, ny});
                }

                if(maze[nx][ny] =='1'){
                    arrived = new int[]{status, nx, ny};
                    return;
                }
            }
        }
    }
}
