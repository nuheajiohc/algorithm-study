import java.io.*;
import java.util.*;

public class Solution {

    static int N, maxCnt, startX, startY;
    static int[] dx = {1, 1, -1, -1}, dy = {1, -1, -1, 1};
    static int[][] cafe = new int[20][20];
    static boolean[] unique = new boolean[101];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int tc=1; tc<=TC; tc++){
            N = Integer.parseInt(br.readLine());

            for(int i=0; i<N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++){
                    cafe[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            maxCnt = -1;
            for(int i=0; i<N-2; i++){
                for(int j=0; j<N-1; j++){
                    startX = i; 
                    startY = j;
                    unique[cafe[i][j]] = true;
                    btk(i, j, 1, 0);
                    unique[cafe[i][j]] = false;
                }
            }
            sb.append("#").append(tc).append(" ").append(maxCnt).append("\n");
        }
        System.out.println(sb);
    }

    static void btk(int x, int y, int cnt, int dir){
        if(dir==4){
            return;
        }
        int nx = x + dx[dir];
        int ny = y + dy[dir];
        
        if(nx<0 || nx>=N || ny<0 || ny>=N) return;

        if(nx == startX && ny == startY && cnt >=4){
            maxCnt = Math.max(maxCnt, cnt);
            return;
        }

        if(unique[cafe[nx][ny]]) return;

        unique[cafe[nx][ny]] = true;
        btk(nx, ny, cnt+1, dir);
        btk(nx, ny, cnt+1, dir+1);
        unique[cafe[nx][ny]] = false;
    }
}
