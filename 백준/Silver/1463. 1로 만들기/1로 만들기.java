import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int in = Integer.parseInt(br.readLine());
        int[] dp = new int[1000001];
        dp[2] = 1;
        dp[3] = 1;
        for (int i = 4; i <= in; i++) {
            int minValue = dp[i - 1] + 1;
            if (i % 2 == 0) {
                minValue = Math.min(minValue, dp[i / 2] + 1);
            }
            if (i % 3 == 0) {
                minValue = Math.min(minValue, dp[i / 3] + 1);
            }
            dp[i] = minValue;
        }
        System.out.println(dp[in]);
    }
}
