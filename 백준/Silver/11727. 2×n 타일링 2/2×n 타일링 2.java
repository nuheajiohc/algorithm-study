import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
  
  private static final int MOD = 10007;

  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    int[] dp = new int[1001];
    dp[1] = 1;
    dp[2] = 3;
    for(int i=3; i<=N; i++){
      dp[i]= (dp[i-1]+dp[i-2]*2)%MOD;
    }
    System.out.println(dp[N]);
  }
}
