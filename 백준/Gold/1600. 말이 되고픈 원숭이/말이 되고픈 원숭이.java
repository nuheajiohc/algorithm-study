import java.io.*;
import java.util.*;

public class Main {

    static int W, H, K;
    static int[][] board;
    static int[][][] visited;
    static int[] dx = {1, -1, 0, 0, 1, 1, 2, 2, -1, -1, -2, -2};
    static int[] dy = {0, 0, 1, -1, 2, -2, 1, -1, 2, -2, 1, -1};
    static Queue<int[]> q = new ArrayDeque<>();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        visited = new int[H][W][K+1];
        board = new int[H][W];
        for(int i=0; i<H; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<W; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
                Arrays.fill(visited[i][j], -1);
            }
        }

        q.offer(new int[]{0, 0, K});
        visited[0][0][K] = 0;

        int idx = -1;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0]; int y = cur[1];
            int k = cur[2];

            boolean end;
            if(k>0){
                end = iterate(x, y, k, 12);
            }else{
                end = iterate(x, y, k, 4);
            }
            if(end) break;
        }
        
        int answer = Integer.MAX_VALUE;
        for(int k=0; k<=K; k++){
            if(visited[H-1][W-1][k]==-1) continue;
            answer = Math.min(answer, visited[H-1][W-1][k]);
        }

        if(answer == Integer.MAX_VALUE){
            System.out.println(-1);
        }else{
            System.out.println(answer);
        }
    }

    static boolean iterate(int x, int y, int k, int limit){
        for(int dir=0; dir<limit; dir++){
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if(nx<0 || nx>=H || ny<0 || ny>=W) continue;
            if(board[nx][ny]==1) continue;

            if(dir<4){
                if(visited[nx][ny][k]>=0) continue;
                visited[nx][ny][k] = visited[x][y][k]+1;
                q.offer(new int[]{nx, ny, k});
            }else{
                if(visited[nx][ny][k-1] >=0) continue;
                visited[nx][ny][k-1] = visited[x][y][k] + 1;
                q.offer(new int[]{nx, ny, k-1});
                
            }
            if(nx==H-1 && ny==W-1) return true;
        }
        return false;
    }
}
