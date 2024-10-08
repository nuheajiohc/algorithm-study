import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[] card = new int[N+1];
    StringTokenizer st = new StringTokenizer(br.readLine());;
    for(int i=1; i<=N; i++){
      card[i] = Integer.parseInt(st.nextToken());
    }

    int[] dp = new int[N+1];
    dp[1]= card[1];
    for(int i=2; i<=N; i++){
      dp[i] = card[i];
      for(int j=1; j<i; j++){
        dp[i] = Math.max(dp[i],dp[j]+dp[i-j]);
      }
    }
    System.out.println(dp[N]);
  }
}
