import java.io.*;

public class Main {
    private static int VALUE = 1_000_000_009;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        long dp[] = new long[1000001];
        dp[1]=1;
        dp[2]=2;
        dp[3]=4;
        for(int i=4; i<1000001; i++){
            dp[i] = (dp[i-1]+dp[i-2]+dp[i-3])%VALUE;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<T; i++){
            int n = Integer.parseInt(br.readLine());
            sb.append(dp[n]).append("\n");
        }
        System.out.println(sb.toString());
    }
}
