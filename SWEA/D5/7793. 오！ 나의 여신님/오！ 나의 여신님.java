import java.io.*;
import java.util.*;

public class Solution {

    static int[] dx = {0, 0, 1, -1}, dy = {1, -1, 0, 0};
    static int N, M;
    static char[][] map = new char[50][50];
    static int[][] devilVisited, sVisited;
    static char DEVIL = '*', STONE = 'X', GODDESS = 'D';
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int tc=1; tc<=TC; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            int sX = 0;
            int sY = 0;
            int goddessX = 0;
            int goddessY = 0;

            Queue<int[]> queue = new ArrayDeque<>();
            devilVisited = new int[N][M];
            sVisited = new int[N][M];

            for(int i=0; i<N; i++){
                String line = br.readLine();
                for(int j=0; j<M; j++){
                    map[i][j] = line.charAt(j);
                    if(map[i][j] == DEVIL){
                        queue.offer(new int[]{i ,j});
                        devilVisited[i][j] = 1;
                    }
                    if(map[i][j] == 'S'){
                        sX = i;
                        sY = j;
                    }
                    if(map[i][j] == GODDESS){
                        goddessX = i;
                        goddessY = j;
                    }
                }
            }

            while(!queue.isEmpty()){
                int[] cur = queue.poll();
                for(int dir=0; dir<4; dir++){
                    int nx = cur[0] + dx[dir];
                    int ny = cur[1] + dy[dir];
                    if(isOutOfRange(nx, ny)) continue;
                    if(map[nx][ny]==STONE || map[nx][ny] == GODDESS || devilVisited[nx][ny]>0) continue;
                    devilVisited[nx][ny] = devilVisited[cur[0]][cur[1]] + 1; 
                    queue.offer(new int[]{nx, ny});
                }
            }

            sVisited[sX][sY] = 1;
            queue.offer(new int[]{sX, sY});
            while(!queue.isEmpty()){
                int[] cur = queue.poll();
                for(int dir=0; dir<4; dir++){
                    int nx = cur[0] + dx[dir];
                    int ny = cur[1] + dy[dir];
                    if(isOutOfRange(nx, ny)) continue;
                    if(map[nx][ny]==STONE || sVisited[nx][ny]>0) continue;
                    if(devilVisited[nx][ny]>0 && sVisited[cur[0]][cur[1]]+1 >= devilVisited[nx][ny]) continue;
                    sVisited[nx][ny] = sVisited[cur[0]][cur[1]] + 1; 
                    queue.offer(new int[]{nx, ny});
                }
            }

            sb.append("#").append(tc).append(" ");
            if(sVisited[goddessX][goddessY]>0){
                sb.append(sVisited[goddessX][goddessY]-1);
            }else{
                sb.append("GAME OVER");
            }
            sb.append("\n");

        }
        System.out.println(sb);
    }

    static boolean isOutOfRange(int x, int y){
        return x<0 || x>=N || y<0 || y>=M;
    }
}
