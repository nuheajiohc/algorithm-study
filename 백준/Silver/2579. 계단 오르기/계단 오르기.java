import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[][] dp = new int[T + 1][2];
        int[] stair = new int[T+1];

        for (int i = 1; i < T + 1; i++) {
            stair[i] = Integer.parseInt(br.readLine());
        }
        dp[1] = new int[] { 0, stair[1] };
        if (T == 1) {
            System.out.println(stair[1]);
            return;
        }
        if (T > 1) {
            for (int i = 2; i <= T; i++) {
                dp[i][0] = dp[i - 1][1];
                dp[i][1] = Math.max(dp[i - 2][0] + stair[i - 1], dp[i - 1][0]) + stair[i];
            }
        }
        System.out.println(dp[T][1]);
    }
}
