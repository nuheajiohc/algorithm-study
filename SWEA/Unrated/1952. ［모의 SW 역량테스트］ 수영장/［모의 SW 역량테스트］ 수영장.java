import java.io.*;
import java.util.*;

public class Solution {

    static int[] price, plan, dp;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int tc=1; tc<=TC; tc++){
            price = new int[4];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<4; i++){
                price[i] = Integer.parseInt(st.nextToken());
            }

            plan = new int[13];
            st = new StringTokenizer(br.readLine());
            for(int i=1; i<13; i++){
                plan[i] = Integer.parseInt(st.nextToken());
            }

            dp = new int[13];
            for(int i=1; i<=12; i++){
                dp[i] = dp[i-1]+ Math.min(plan[i]*price[0], price[1]);

                if(i>=3){
                    dp[i] = Math.min(dp[i], dp[i-3]+price[2]);
                }
            }

            int minSum = Math.min(dp[12], price[3]);
            sb.append("#").append(tc).append(" ").append(minSum).append("\n");
        }
        System.out.println(sb);
    }
}
