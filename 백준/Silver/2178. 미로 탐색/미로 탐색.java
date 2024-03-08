import java.io.*;
import java.util.*;

public class Main {

    private static int[] dx = { 1, -1, 0, 0 };
    private static int[] dy = { 0, 0, 1, -1 };
    private static int[][] vis;
    private static int[][] board;
    private static int h, w;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        h = Integer.parseInt(temp[0]);
        w = Integer.parseInt(temp[1]);
        vis = new int[h][w];
        board = new int[h][w];
        for (int i = 0; i < h; i++) {
            String s = br.readLine();
            for (int j = 0; j < w; j++) {
                board[i][j] = s.charAt(j) - '0';
            }
        }
        bfs(0, 0);
        System.out.println(vis[h - 1][w - 1]);
    }

    public static void bfs(int i, int j) {
        vis[i][j] = 1;
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[] { i, j });
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int dir = 0; dir < 4; dir++) {
                int nx = cur[0] + dx[dir];
                int ny = cur[1] + dy[dir];
                if (nx < 0 || ny < 0 || nx >= h || ny >= w) {
                    continue;
                }
                if (vis[nx][ny] == 0 && board[nx][ny] == 1) {
                    q.offer(new int[] { nx, ny });
                    vis[nx][ny] = vis[cur[0]][cur[1]] + 1;
                }
            }
        }
    }
}