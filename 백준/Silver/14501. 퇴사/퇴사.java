import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] T = new int[N+1];
        int[] P = new int[N+1];
        int[] dp = new int[N+2];
        for(int i=1; i<=N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=1; i<=N; i++){
            dp[i+1] = Math.max(dp[i+1],dp[i]);
            if(i+T[i]>N+1){
                continue;
            }
            dp[i+T[i]] = Math.max(dp[i+T[i]], dp[i]+P[i]); 
        }
        Arrays.sort(dp);
        System.out.println(dp[N+1]);
    }   
}
