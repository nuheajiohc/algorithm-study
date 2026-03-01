import java.io.*;
import java.util.*;

public class Solution {

    static int N;
    static int[][] board = new int[1000][1000];
    static int[][] memo;
    static int[] dx = {0, 0, 1, -1}, dy = {1, -1, 0, 0};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=TC; tc++){
            N = Integer.parseInt(br.readLine());

            memo = new int[N][N];

            for(int i=0; i<N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++){
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int maxLen = 0;
            int num = 0;
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    int len = recursion(i, j);
                    if(maxLen < len){
                        maxLen = len;
                        num = board[i][j];
                    }else if(maxLen == len){
                        num = Math.min(num, board[i][j]);
                    }
                }
            }
            sb.append("#").append(tc).append(" ").append(num).append(" ").append(maxLen).append("\n");
        }

        System.out.println(sb);
    }

    static int recursion(int x, int y){
        if(memo[x][y]>0) return memo[x][y];

        memo[x][y] = 1;
        for(int dir=0; dir<4; dir++){
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if(nx<0 || nx>=N || ny<0 || ny>=N) continue;
            if(board[x][y]+1==board[nx][ny]) {
                memo[x][y] += recursion(nx ,ny);
            }
        }

        return memo[x][y];
    }
}
