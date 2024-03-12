import java.io.*;
import java.util.*;

public class Main {

    private static int[] dx = { 1, -1, 0, 0 };
    private static int[] dy = { 0, 0, 1, -1 };
    private static int[][] f_vis, p_vis;
    private static char[][] maze;
    private static int R, C;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        R = Integer.parseInt(line[0]);
        C = Integer.parseInt(line[1]);
        maze = new char[R][C];
        f_vis = new int[R][C];
        p_vis = new int[R][C];

        Deque<int[]> f_q = new ArrayDeque<>();
        Deque<int[]> p_q = new ArrayDeque<>();

        for (int i = 0; i < R; i++) {
            String temp = br.readLine();
            for (int j = 0; j < C; j++) {
                maze[i][j] = temp.charAt(j);
                if (maze[i][j] == 'J') {
                    p_vis[i][j] = 1;
                    p_q.offer(new int[] { i, j });
                }
                if (maze[i][j] == 'F') {
                    f_vis[i][j] = 1;
                    f_q.offer(new int[] { i, j });
                }
            }
        }
        fire_bfs(f_q);
        person_bfs(p_q);
    }

    public static void fire_bfs(Deque<int[]> q) {
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int dir = 0; dir < 4; dir++) {
                int nx = cur[0] + dx[dir];
                int ny = cur[1] + dy[dir];

                if (nx < 0 || ny < 0 || nx >= R || ny >= C) {
                    continue;
                }

                if (f_vis[nx][ny] == 0 && maze[nx][ny] != '#') {
                    f_vis[nx][ny] = f_vis[cur[0]][cur[1]] + 1;
                    q.offer(new int[] { nx, ny });
                }
            }
        }
    }

    public static void person_bfs(Deque<int[]> q) {
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int dir = 0; dir < 4; dir++) {
                int nx = cur[0] + dx[dir];
                int ny = cur[1] + dy[dir];
                if (nx < 0 || ny < 0 || nx >= R || ny >= C) {
                    System.out.println(p_vis[cur[0]][cur[1]]);
                    return;
                }

                if (p_vis[nx][ny] == 0 && maze[nx][ny] != '#') {
                    int temp = p_vis[cur[0]][cur[1]] + 1;
                    if (temp < f_vis[nx][ny] || f_vis[nx][ny] == 0) {
                        p_vis[nx][ny] = temp;
                        q.offer(new int[] { nx, ny });
                    }
                }
            }
        }

        System.out.println("IMPOSSIBLE");
    }
}
