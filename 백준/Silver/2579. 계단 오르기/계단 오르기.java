import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] stair = new int[N+1];
        for(int i=1; i<=N; i++){
            stair[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[N+1];
        dp[1]=stair[1];
        if(N>1) dp[2]=stair[2]+dp[1];
        if(N>2) dp[3]=stair[3]+ Math.max(stair[1],stair[2]);
        for(int i=4; i<=N; i++){
            dp[i] = stair[i] + Math.max(dp[i-2], dp[i-3]+stair[i-1]);
        }  
        System.out.println(dp[N]);
    }
}
