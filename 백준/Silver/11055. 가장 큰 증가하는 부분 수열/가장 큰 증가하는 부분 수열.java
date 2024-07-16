import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] seq = new int[N];
        for(int i=0; i<N; i++){
            seq[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N];
        int maxVal=0;
        for(int i=0; i<N; i++){
            dp[i] = seq[i];
            for(int j=0; j<i; j++){
                if(seq[j]<seq[i]) dp[i] = Math.max(dp[j]+seq[i],dp[i]);
            }
            maxVal = Math.max(maxVal,dp[i]);
        }
        System.out.println(maxVal);
    }
}
