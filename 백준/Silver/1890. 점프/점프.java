import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  private static int[] dx = {0, 1};
  private static int[] dy = {1, 0};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    int[][] board = new int[N + 1][N + 1];
    for (int i = 1; i <= N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 1; j <= N; j++) {
        board[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    long[][] dp = new long[N + 1][N + 1];
    dp[1][1] =1;
    for (int i = 1; i <= N; i++) {
      for (int j = 1; j <= N; j++) {
        if(dp[i][j]==0) continue;
        if(i==N && j==N) break;
        for (int dir = 0; dir < 2; dir++) {
          int nx = i + board[i][j] * dx[dir];
          int ny = j + board[i][j] * dy[dir];
          if(nx > N || ny > N) continue;
          dp[nx][ny] += dp[i][j];
        }
      }
    }
    System.out.println(dp[N][N]);
  }
}
