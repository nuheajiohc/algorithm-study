import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] workTime = new int[n+1][2];
        int[][] moveTime = new int[n][2];
        for(int i=1; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A_workTime = Integer.parseInt(st.nextToken());
            int B_workTime = Integer.parseInt(st.nextToken());
            workTime[i] = new int[]{A_workTime, B_workTime};
            int AB_moveTime = Integer.parseInt(st.nextToken());
            int BA_moveTime = Integer.parseInt(st.nextToken());
            moveTime[i] = new int[]{AB_moveTime, BA_moveTime};
        }
        StringTokenizer st  = new StringTokenizer(br.readLine());
        int A_lastWorkTime = Integer.parseInt(st.nextToken());
        int B_lastWorkTime = Integer.parseInt(st.nextToken());
        workTime[n] = new int[]{A_lastWorkTime, B_lastWorkTime};
        
        int[][] dp = new int[n+1][2];
        dp[1] = workTime[1];
        for(int i=2; i<=n; i++){
            dp[i][0] = Math.min(dp[i-1][0],dp[i-1][1]+moveTime[i-1][1])+workTime[i][0];
            dp[i][1] = Math.min(dp[i-1][1],dp[i-1][0]+moveTime[i-1][0])+workTime[i][1];
        }
        System.out.println(Math.min(dp[n][0],dp[n][1]));
    }
}
