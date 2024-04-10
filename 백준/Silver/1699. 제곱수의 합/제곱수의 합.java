import java.io.*;

public class Main {
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+1];
        for(int i=1; i<=N; i++){
            int temp=1;
            dp[i]=i;
            while(temp*temp<=i){
                dp[i] = Math.min(dp[i],1+dp[i-temp*temp]);
                temp++;
            }
        }
        System.out.println(dp[N]);
    }
}
