import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] wines = new int[N+1];
        for(int i=1; i<=N; i++){
            wines[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[N+1];
        dp[1] = wines[1];
        if(N>1) dp[2] = wines[1] + wines[2];
        for(int i=3; i<=N; i++){
            dp[i] = Math.max(dp[i-2],dp[i-3]+wines[i-1]) + wines[i];
            dp[i] = Math.max(dp[i], dp[i-1]);
        }
        System.out.println(Math.max(dp[N],dp[N-1]));
    }
}
