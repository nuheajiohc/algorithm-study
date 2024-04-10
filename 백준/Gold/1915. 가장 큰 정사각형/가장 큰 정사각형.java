import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] square = new int[n+1][m+1];
        for(int i=1; i<=n; i++){
            String s = br.readLine();
            for(int j=1; j<=m; j++){
                square[i][j] = s.charAt(j-1)-'0';
            }
        }

        int[][] dp = new int[n+1][m+1];
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                dp[i][j] = square[i][j];
                int temp=Math.min(dp[i-1][j],dp[i][j-1]);
                temp = Math.min(temp, dp[i-1][j-1]);
                if(temp>=1 && square[i][j]==1){
                    dp[i][j]=(temp+1);
                }
            }
        }
        int maxLength=0;
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(maxLength<dp[i][j]){
                    maxLength = dp[i][j];
                }
            }
        }
        System.out.println(maxLength*maxLength);
    }
}
