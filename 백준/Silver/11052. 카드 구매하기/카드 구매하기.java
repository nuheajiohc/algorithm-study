import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] card = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            card[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N+1];
        for(int i=1; i<=N; i++){
            for(int j=i; j<=N; j++){
                dp[j] = Math.max(dp[j-i]+card[i],dp[j]);
            }
        }
        System.out.println(dp[N]);
    }
}
