import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    int[][] dp = new int[N+1][4];
    for(int i=1; i<=N; i++){
      StringTokenizer st = new StringTokenizer(br.readLine());
      int r = Integer.parseInt(st.nextToken());
      int g = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      dp[i][1] = Math.min(dp[i-1][2], dp[i-1][3]) + r;
      dp[i][2] = Math.min(dp[i-1][1], dp[i-1][3]) + g;
      dp[i][3] = Math.min(dp[i-1][1], dp[i-1][2]) + b;
    }
    int min  = Math.min(dp[N][1],dp[N][2]);
    min = Math.min(min, dp[N][3]);
    System.out.println(min);
  }
}
