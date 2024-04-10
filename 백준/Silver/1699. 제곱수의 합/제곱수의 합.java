import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+1];
        for(int i=1; i<=N; i++){
            if(Math.sqrt(i)%1==0){
                dp[i] = 1;
                continue;
            }
            int temp=1;
            int minVal=Integer.MAX_VALUE;
            while(temp*temp<=i){
                minVal = Math.min(minVal,dp[temp*temp]+dp[i-temp*temp]);
                temp++;
            }
            dp[i] =minVal;
        }
        System.out.println(dp[N]);
    }
}
