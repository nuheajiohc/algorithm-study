import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        long[][] dp = new long[N+1][K+1];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int W = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());

            for(int j=1; j<K+1; j++){
                if(W>j) dp[i+1][j] = dp[i][j];
                else dp[i+1][j] = Math.max(dp[i][j],dp[i][j-W]+V);
            }
        }

        System.out.println(dp[N][K]);
    }
}
