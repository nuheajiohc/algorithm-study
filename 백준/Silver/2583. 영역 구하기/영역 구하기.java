import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  private static int[] dx = {0, 0, 1, -1};
  private static int[] dy = {1, -1, 0, 0};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());
    int[][] map = new int[N][M];
    while (K-- > 0) {
      st = new StringTokenizer(br.readLine());
      int y1 = Integer.parseInt(st.nextToken());
      int x1 = Integer.parseInt(st.nextToken());
      int y2 = Integer.parseInt(st.nextToken());
      int x2 = Integer.parseInt(st.nextToken());

      for (int i = x1; i < x2; i++) {
        for (int j = y1; j < y2; j++) {
          map[i][j] = 1;
        }
      }
    }

    int count = 0;
    List<Integer> area = new ArrayList<>();
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (map[i][j] == 1) continue;
        count++;
        int tempArea = 1;
        map[i][j] = 1;
        Queue<Point> q = new ArrayDeque<>();
        q.offer(new Point(i, j));
        while (!q.isEmpty()) {
          Point point = q.poll();
          for (int dir = 0; dir < 4; dir++) {
            int nx = point.x + dx[dir];
            int ny = point.y + dy[dir];
            if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
              continue;
            }
            if (map[nx][ny] == 1) {
              continue;
            }
            map[nx][ny] = 1;
            q.offer(new Point(nx, ny));
            tempArea++;
          }
        }
        area.add(tempArea);
      }
    }
    Collections.sort(area);
    System.out.println(count);
    StringBuilder sb = new StringBuilder();
    for(int sum  :area){
      sb.append(sum).append(" ");
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
