import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] sequence = new int[N];
        for(int i=0; i<N; i++){
            sequence[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N];
        int maxCount=0;
        for(int i=0; i<N; i++){
            dp[i]=1;
            for(int j=0; j<N; j++){
                if(sequence[i]>sequence[j]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            maxCount = Math.max(maxCount,dp[i]);
        }
        System.out.println(maxCount);
    }
}
