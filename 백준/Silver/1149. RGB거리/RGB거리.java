import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N][3];
        StringTokenizer st = new StringTokenizer(br.readLine());
        dp[0] = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        for(int i=1; i<N; i++){
            st = new StringTokenizer(br.readLine());
            dp[i][0] = Integer.parseInt(st.nextToken()) + Math.min(dp[i-1][1],dp[i-1][2]);
            dp[i][1] = Integer.parseInt(st.nextToken()) + Math.min(dp[i-1][0],dp[i-1][2]);
            dp[i][2] = Integer.parseInt(st.nextToken()) + Math.min(dp[i-1][0],dp[i-1][1]);
        }
        System.out.println(Arrays.stream(dp[N-1]).min().getAsInt());
    }
}