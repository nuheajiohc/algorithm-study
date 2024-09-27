import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

public class Main {

  private static int[] dx = {0, 0, 1, -1};
  private static int[] dy = {1, -1, 0, 0};
  private static int N;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    int[][] board = new int[N][N];
    for (int i = 0; i < N; i++) {
      String line = br.readLine();
      for (int j = 0; j < N; j++) {
        board[i][j] = line.charAt(j) - '0';
      }
    }

    List<Integer> order = new ArrayList<>();
    boolean[][] vis = new boolean[N][N];
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (board[i][j] == 0 || vis[i][j]) {
          continue;
        }
        int count = 1;
        vis[i][j] = true;
        Deque<Point> queue = new ArrayDeque<>();
        queue.offer(new Point(i, j));
        while (!queue.isEmpty()) {
          Point point = queue.poll();
          for (int dir = 0; dir < 4; dir++) {
            int nx = point.x + dx[dir];
            int ny = point.y + dy[dir];
            if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
              continue;
            }
            if (vis[nx][ny] || board[nx][ny] == 0) {
              continue;
            }
            vis[nx][ny] = true;
            queue.offer(new Point(nx, ny));
            count++;
          }
        }
        order.add(count);
      }
    }
    Collections.sort(order);
    StringBuilder sb = new StringBuilder();
    sb.append(order.size()).append("\n");
    for (int number : order) {
      sb.append(number).append("\n");
    }
    System.out.println(sb);
  }

  public static class Point {

    int x;
    int y;

    public Point(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }
}
