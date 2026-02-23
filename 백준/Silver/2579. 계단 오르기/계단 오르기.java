import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];

        for(int i=1; i<=N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[][] dp = new int[N+1][3];
        dp[1][1] = arr[1];
        for(int i=2; i<=N; i++){
            dp[i][0] = Math.max(dp[i-1][1], dp[i-1][2]);
            dp[i][1] = arr[i] + dp[i-1][0];
            dp[i][2] = arr[i] + dp[i-1][1];
        }

        System.out.println(Math.max(dp[N][1], dp[N][2]));
    }
}