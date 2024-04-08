import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n+1];
        int[] dp = new int[n+1];
        int maxVal =-1000;
        for(int i=1; i<=n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = Math.max(dp[i-1]+arr[i],arr[i]);
            maxVal = Math.max(maxVal, dp[i]);
        }

        System.out.println(maxVal);
    }
}
