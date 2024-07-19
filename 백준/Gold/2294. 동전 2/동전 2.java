import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] seq = new int[N+1];
        for(int i=1; i<=N; i++){
            seq[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[K+1];
        for(int i=1; i<=K; i++){
            dp[i] = 10001;
        }

        for(int i=1; i<=N; i++){
            for(int j=seq[i]; j<=K; j++){
                dp[j] = Math.min(dp[j], dp[j-seq[i]]+1);
            }
        }
        System.out.println(dp[K]==10001?-1: dp[K]);
    }
}
