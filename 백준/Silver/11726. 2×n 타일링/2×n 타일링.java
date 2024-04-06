import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new  int[N];
        dp[0] = 1;
        if(N>1){
            dp[1] = 2;
        }
        for(int i=2; i<N;i++){
            dp[i] = (dp[i-1] + dp[i-2])%10007;
        }
        System.out.println(dp[N-1]);
    }
}
