import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1]; 
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long[] dp = new long[N+1];
        Arrays.fill(dp, Long.MAX_VALUE);
        dp[1]=0;
        for(int i=1; i<=N; i++){
            for(int j=i+1; j<=N; j++){
                long strength = (long)(j-i) * (1 + Math.abs(arr[j]- arr[i]));
                long cand = Math.max(dp[i], strength);
                dp[j] = Math.min(cand, dp[j]);
            }
        }
        System.out.println(dp[N]);
    }
}
