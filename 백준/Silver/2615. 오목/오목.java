import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  private static int[] dx = {-1, 0, 1,1};
  private static int[] dy = {1, 1, 1,0};
  private static int[][] board = new int[20][20];

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    for (int i = 1; i < 20; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 1; j < 20; j++) {
        board[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    findWinner();
  }

  public static boolean isOutOfRange(int x, int y) {
    return x <= 0 || x > 19 || y <= 0 || y > 19;
  }

  public static void findWinner() {
    for (int j = 1; j < 20; j++) {
      for (int i = 1; i < 20; i++) {
        if (board[i][j] == 0) {
          continue;
        }
        for (int dir = 0; dir < 4; dir++) {
          int count = 1;
          for (int k = 1; k <= 5; k++) {
            int nx = i + dx[dir] * k;
            int ny = j + dy[dir] * k;
            if (isOutOfRange(nx, ny) || board[i][j] != board[nx][ny]) {
              break;
            }
            if (board[i][j] == board[nx][ny]) {
              count++;
            }
          }
          if (count == 5 && board[i][j]!=board[i-dx[dir]][j-dy[dir]]) {
            System.out.println(board[i][j]);
            System.out.println(i + " " + j);
            return;
          }
        }
      }
    }
    System.out.println(0);
  }
}
