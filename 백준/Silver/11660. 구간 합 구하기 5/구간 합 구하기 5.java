import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    int[][] arr = new int[n+1][n+1];
    for(int i=1; i<=n; i++){
      st = new StringTokenizer(br.readLine());
      for(int j=1; j<=n; j++){
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    int[][] dp = new int[n+1][n+1];
    for(int i=1; i<=n; i++){
      int tempSum = 0;
      for(int j=1; j<=n; j++){
        tempSum += arr[i][j];
        dp[i][j] = dp[i-1][j]+tempSum;
      }
    }

    StringBuilder sb = new StringBuilder();
    while(m-->0){
      st = new StringTokenizer(br.readLine());
      int x1 = Integer.parseInt(st.nextToken());
      int y1 = Integer.parseInt(st.nextToken());
      int x2 = Integer.parseInt(st.nextToken());
      int y2 = Integer.parseInt(st.nextToken());

      int sum = dp[x2][y2] - dp[x1-1][y2] - dp[x2][y1-1]+dp[x1-1][y1-1];
      sb.append(sum).append("\n");
    }
    System.out.println(sb);
  }
}
