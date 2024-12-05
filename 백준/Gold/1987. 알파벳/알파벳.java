import java.io.*;
import java.util.*;

public class Main {

  private static int R, C;
  private static char[][] board;
  private static boolean[] used;
  private static int[] dx = {0, 0, 1, -1};
  private static int[] dy = {1, -1, 0, 0};

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    R = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());

    board = new char[R][C];
    for (int i = 0; i < R; i++) {
      board[i] = br.readLine().toCharArray();
    }

    used = new boolean[26];
    int result = btk(0, 0);
    System.out.println(result);
  }

  public static int btk(int x, int y) {
    used[board[x][y] - 'A'] = true;
    int maxCount = 0;

    for (int dir = 0; dir < 4; dir++) {
      int nx = x + dx[dir];
      int ny = y + dy[dir];

      if (isInBounds(nx, ny) && !used[board[nx][ny] - 'A']) {
        maxCount = Math.max(maxCount, btk(nx, ny));
      }
    }

    used[board[x][y] - 'A'] = false;
    return maxCount + 1;
  }

  public static boolean isInBounds(int x, int y) {
    return x >= 0 && x < R && y >= 0 && y < C;
  }
}
