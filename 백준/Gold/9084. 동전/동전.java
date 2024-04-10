import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++){
            int N = Integer.parseInt(br.readLine());
            int[] coin = new int[N+1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++){
                coin[j] = Integer.parseInt(st.nextToken());
            }
            int M = Integer.parseInt(br.readLine());
            int[] dp = new int[M+1];
            dp[0] =1;
            for(int j=1; j<=N; j++){
                for(int k=j; k<=M; k++){
                    if(k>=coin[j]) dp[k] += dp[k-coin[j]];
                }
            }
            System.out.println(dp[M]);
        }
    }
}
