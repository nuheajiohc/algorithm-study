import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] board = new int[N+1][N+1];
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            int sum=0;
            for(int j=1; j<=N; j++){
                sum += Integer.parseInt(st.nextToken());
                board[i][j] = sum;
            }
        }
        for(int i=2; i<=N; i++){
            for(int j=1; j<=N; j++){
                board[i][j] += board[i-1][j];
            }
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int result=board[x2][y2]-board[x2][y1-1]-board[x1-1][y2]+board[x1-1][y1-1];
            sb.append(result).append("\n");
        }
        System.out.println(sb.toString());
    }
}
