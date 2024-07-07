import java.io.*;
import java.util.*;

public class Main {

    private static final int MAX_VALUE = 1000*1000+1;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] house = new int[N+1][3];
        int[][] dp = new int[N+1][3];

        for(int i=1; i<=N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int red = Integer.parseInt(st.nextToken());
            int green = Integer.parseInt(st.nextToken());
            int blue = Integer.parseInt(st.nextToken());
            house[i] = new int[]{red,green,blue};
        }


        int minValue=Integer.MAX_VALUE;
        for(int k=0; k<3; k++){
            Arrays.fill(dp[1],MAX_VALUE);
            dp[1][k] = house[1][k];
            for(int i=2; i<=N; i++){
                dp[i][0]= Math.min(dp[i-1][1],dp[i-1][2]) + house[i][0];
                dp[i][1]= Math.min(dp[i-1][0],dp[i-1][2]) + house[i][1];
                dp[i][2]= Math.min(dp[i-1][0],dp[i-1][1]) + house[i][2];
            }
            for(int i=0; i<3; i++){
                if(k==i) continue;
                minValue = Math.min(minValue, dp[N][i]);
            }
        }
        System.out.println(minValue);
    }
}
