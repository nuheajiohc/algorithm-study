import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+2];

        for(int i=1; i<=N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int T = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());
            dp[i+1] = Math.max(dp[i+1],dp[i]);
            if(i+T>N+1) continue;
            dp[i+T] = Math.max(dp[i+T],dp[i]+P);
        }

        System.out.println(dp[N+1]);
    }
}
