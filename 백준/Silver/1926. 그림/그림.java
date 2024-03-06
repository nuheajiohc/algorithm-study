import java.io.*;
import java.util.*;

public class Main {

    private static int h;
    private static int w;
    private static int[][] vis;
    private static int[][] paper;
    private static int siz;
    private static int[] dx = { 1, -1, 0, 0 };
    private static int[] dy = { 0, 0, 1, -1 };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        paper = new int[h][w];
        vis = new int[h][w];
        for (int i = 0; i < h; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < w; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (vis[i][j] == 1 || paper[i][j] == 0) {
                    continue;
                }
                count++;
                Deque<int[]> q = new ArrayDeque<>();
                vis[i][j] = 1;
                q.offer(new int[] { i, j });
                bfs(q);
            }
        }

        System.out.println(count);
        System.out.println(siz);
    }

    public static void bfs(Deque<int[]> q) {
        int temp = 1;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int dir = 0; dir < 4; dir++) {
                int nx = cur[0] + dx[dir];
                int ny = cur[1] + dy[dir];
                if (nx < 0 || ny < 0 || nx >= h || ny >= w) {
                    continue;
                }

                if (vis[nx][ny] == 0 && paper[nx][ny] == 1) {
                    vis[nx][ny] = 1;
                    temp++;
                    q.offer(new int[] { nx, ny });
                }
            }
        }
        siz = Math.max(siz, temp);
    }
}
