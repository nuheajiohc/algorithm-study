import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] dp = new int[41][2];
        dp[0] = new int[]{1,0};
        dp[1] = new int[]{0,1};
        for(int i=2; i<=40; i++){
            dp[i][0] = dp[i-1][0]+dp[i-2][0];
            dp[i][1] = dp[i-1][1]+dp[i-2][1];
        }

        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while(T-->0){
            int N = Integer.parseInt(br.readLine());
            sb.append(dp[N][0]).append(" ").append(dp[N][1]).append("\n");
        }   
        System.out.println(sb);
    }
}
