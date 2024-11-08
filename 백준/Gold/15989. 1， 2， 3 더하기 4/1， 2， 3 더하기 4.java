import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[][] dp = new int[10001][4];
        dp[1][1] = 1;
        dp[2] = new int[]{0,1,1,0};
        dp[3] = new int[]{0,1,1,1};
        for(int i=4; i<=10000; i++){
            dp[i][1] = dp[i-1][1];
            dp[i][2] = dp[i-2][1]+dp[i-2][2];
            dp[i][3] = dp[i-3][1]+dp[i-3][2]+dp[i-3][3];
        }

        StringBuilder sb = new StringBuilder();
        while(T-->0){
            int N = Integer.parseInt(br.readLine());
            sb.append(dp[N][1]+dp[N][2]+dp[N][3]).append("\n");
        }
        System.out.println(sb);
    }
}
