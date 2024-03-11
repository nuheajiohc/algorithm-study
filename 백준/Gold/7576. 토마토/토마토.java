import java.io.*;
import java.util.*;

public class Main {

    private static int M, N;
    private static int[][] board;
    private static int[][] vis;
    private static int[] dx = { 1, -1, 0, 0 };
    private static int[] dy = { 0, 0, 1, -1 };
    private static Deque<int[]> q;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        M = Integer.parseInt(temp[0]);
        N = Integer.parseInt(temp[1]);
        board = new int[N][M];
        vis = new int[N][M];
        q = new ArrayDeque<>();
        int check = 0;
        for (int i = 0; i < N; i++) {
            temp = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(temp[j]);
                if (board[i][j] == 1) {
                    q.offer(new int[] { i, j });
                    vis[i][j] = 1;
                }
                if (board[i][j] != 0) {
                    check++;
                }
            }
        }
        if (check == N * M) {
            System.out.println(0);
            return;
        }

        bfs();
        int max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (vis[i][j] > max) {
                    max = vis[i][j];
                }
                if (vis[i][j] == 0 && board[i][j] != -1) {
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(max - 1);
    }

    public static void bfs() {
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int dir = 0; dir < 4; dir++) {
                int nx = cur[0] + dx[dir];
                int ny = cur[1] + dy[dir];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                    continue;
                }
                if (vis[nx][ny] == 0 && board[nx][ny] == 0) {
                    vis[nx][ny] = vis[cur[0]][cur[1]] + 1;
                    q.offer(new int[] { nx, ny });
                }
            }
        }
    }
}
