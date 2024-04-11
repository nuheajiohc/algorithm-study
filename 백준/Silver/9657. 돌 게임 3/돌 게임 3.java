import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+1];
        if(N>1){
            dp[2] = 1; 
        }
        for(int i=7; i<=N; i++){
            if(dp[i-1]==0 && dp[i-3]==0 && dp[i-4]==0){
                dp[i]=1;
            }
        }
        System.out.println(dp[N]==1? "CY" : "SK");
    }
}
