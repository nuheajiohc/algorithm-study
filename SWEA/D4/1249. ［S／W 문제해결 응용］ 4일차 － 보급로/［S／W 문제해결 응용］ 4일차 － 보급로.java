import java.io.*;
import java.util.*;

public class Solution {

    static int[] dx = {0, 0, 1, -1}, dy = {1, -1, 0, 0};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int tc=1; tc<=TC; tc++){
            int N = Integer.parseInt(br.readLine());
            int[][] board = new int[N][N];
            
            for(int i=0; i<N; i++){
                String line = br.readLine();
                for(int j=0; j<N; j++){
                    board[i][j] = line.charAt(j)-'0';
                }
            }

            PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[2]-b[2]);

            int[][] d = new int[N][N];
            for(int i=0; i<N; i++){
                Arrays.fill(d[i], Integer.MAX_VALUE);
            }
            pq.add(new int[]{0,0,0});
            d[0][0] = 0;
            while(!pq.isEmpty()){
                int[] cur = pq.poll();
                int x = cur[0];
                int y = cur[1];
                int dist = cur[2];
                if(dist != d[x][y]) continue;
                for(int dir=0; dir<4; dir++){
                    int nx = x + dx[dir];
                    int ny = y + dy[dir];
                    if(nx<0 || nx>=N || ny<0 || ny>=N) continue;
                    if(d[nx][ny] <= board[nx][ny]+d[x][y]) continue;
                    d[nx][ny] = board[nx][ny]+d[x][y];
                    pq.add(new int[]{nx, ny, d[nx][ny]});
                }
            }

            sb.append("#").append(tc).append(" ").append(d[N-1][N-1]).append("\n");
        }

        System.out.println(sb);
    }
}
