import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[ ] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][][] dp = new int[N+1][M+2][3];
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            Arrays.fill(dp[i-1][0],600);
            Arrays.fill(dp[i-1][M+1],600);
            for(int j=1; j<=M; j++){
                int cur = Integer.parseInt(st.nextToken());
                for(int k=0; k<3; k++){
                    dp[i][j][k] = Math.min(dp[i-1][j-1+k][(k+1)%3],dp[i-1][j-1+k][(k+2)%3])+cur;
                }
            }
        }
        int min = 600;
        for(int i=1; i<=M; i++){
            for(int j=0; j<3; j++){
                min = Math.min(min, dp[N][i][j]);
            }
        }
        System.out.println(min);
    }
}
