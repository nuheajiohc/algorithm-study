import java.io.*;

public class Main {

    private static final int MOD = 1_000_000_000;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][][] dp = new int[N+1][11][1<<10];
        
        for(int i=1; i<10; i++){
            dp[1][i][1<<i] = 1;
        }

        for(int i=2; i<N+1; i++){
            for(int j=0; j<10; j++){
                for(int k=0; k<1024; k++){
                    int bit = k | (1<<j);
                    if(j==0){
                        dp[i][j][bit] = (dp[i][j][bit]+dp[i-1][j+1][k]) % MOD;
                    }else if(j==9){
                        dp[i][j][bit] = (dp[i][j][bit]+dp[i-1][j-1][k]) % MOD;
                    }else{
                        dp[i][j][bit] = (dp[i][j][bit]+dp[i-1][j-1][k]+dp[i-1][j+1][k]) % MOD;
                    }
                }
            }
        }

        int sum = 0;
        for(int i=0; i<10; i++){
            sum = (sum+dp[N][i][1023]) % MOD;
        }
        System.out.println(sum);
    }
}
