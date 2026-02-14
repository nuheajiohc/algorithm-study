import java.io.*;
import java.util.*;

public class Solution {

    static int N, K, maxH, maxLen;
    static int[][] hiking = new int[8][8];
    static boolean[][] distance;
    static int[] dx = {0, 0, 1, -1}, dy = {1, -1, 0, 0};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int tc=1; tc<=TC; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            distance = new boolean[N][N];
            maxH = 0;
            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++){
                    hiking[i][j] = Integer.parseInt(st.nextToken());
                    maxH = Math.max(maxH, hiking[i][j]);
                }
            }
            
            maxLen = 0;
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(maxH == hiking[i][j]){
                        btk(i, j, K, 1);
                    }
                }
            }
            sb.append("#").append(tc).append(" ").append(maxLen).append("\n");
        }
        System.out.println(sb);
    }

    static void btk(int x, int y, int k, int cnt){
        maxLen = Math.max(maxLen, cnt);
        distance[x][y] = true;
        for(int dir=0; dir<4; dir++){
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if(nx<0 || nx>=N || ny<0 || ny>=N) continue;
            if(distance[nx][ny]) continue;
            if(hiking[nx][ny]<hiking[x][y]){
                distance[nx][ny] = true;
                btk(nx, ny, k, cnt+1);
                distance[nx][ny] = false;
            }else if(k>0 && hiking[nx][ny]-K < hiking[x][y]){
                distance[nx][ny] = true;
                int tmp = hiking[nx][ny];
                hiking[nx][ny] = hiking[x][y] - 1;
                btk(nx, ny, 0, cnt+1);
                hiking[nx][ny] = tmp;
                distance[nx][ny] = false;
            }
        }
        distance[x][y] = false;
    }
}
