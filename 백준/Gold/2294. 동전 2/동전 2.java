import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] dp = new int[K+1];
        Arrays.fill(dp, 10001);
        dp[0]=0;
        for(int i=0; i<N; i++){
            int value = Integer.parseInt(br.readLine());
            for(int j=value; j<=K; j+=1){
                dp[j] = Math.min(dp[j],dp[j-value]+1);
            }
        }

        System.out.println(dp[K]==10001?-1:dp[K]);
    }
}
