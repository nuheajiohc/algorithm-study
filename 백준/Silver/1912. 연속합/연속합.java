import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] dp = new int[N];
        dp[0] = Integer.parseInt(st.nextToken());
        int maxValue=dp[0];
        for(int i=1; i<N; i++){
            int num = Integer.parseInt(st.nextToken());
            dp[i] = Math.max(dp[i-1]+num, num);
            maxValue = Math.max(dp[i],maxValue);
        }
        System.out.println(maxValue);
    }
}