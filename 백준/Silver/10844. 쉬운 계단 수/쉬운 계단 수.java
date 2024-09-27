import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

  private static final int NUM = 1_000_000_000;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    int[][] dp = new int[N+1][10];
    Arrays.fill(dp[1], 1);
    dp[1][0]=0;
    for(int i=2; i<=N; i++) {
      dp[i][0] = dp[i-1][1]%NUM;
      dp[i][9] = dp[i-1][8]%NUM;
      for(int j=1; j<=8; j++) {
        dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1])%NUM;
      }
    }
    int count=0;
    for(int i=0; i<10; i++){
      count= (count+dp[N][i])%NUM;
    }
    System.out.println(count);
  }
}
