import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());

    int[] dp = new int[12];
    dp[1] = 1;
    dp[2] = 2;
    dp[3] = 4;
    for(int i=4; i<12; i++){
      dp[i] = dp[i-1] + dp[i-2]+dp[i-3];
    }

    StringBuilder sb = new StringBuilder();
    while(T-- > 0) {
      int n = Integer.parseInt(br.readLine());
      sb.append(dp[n]).append("\n");
    }
    System.out.println(sb);
  }
}
