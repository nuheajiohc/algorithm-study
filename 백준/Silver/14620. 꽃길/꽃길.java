import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    private static int[][] board;
    private static boolean[][] vis;
    private static int price = Integer.MAX_VALUE;
    private static int N;
    private static int[][] dir = {{1, 0}, {0, 1}, {0, -1}, {-1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N][];
        vis = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        dfs(0, 0);
        System.out.println(price);
    }

    public static void dfs(int count, int curPrice) {
        if (count == 3) {
            price = Math.min(price, curPrice);
            return;
        }

        for (int i = 1; i < N - 1; i++) {
            for (int j = 1; j < N - 1; j++) {
                if (vis[i][j] || isVis(i, j)) {
                    continue;
                }
                vis[i][j] = true;
                checkVis(i, j);
                dfs(count + 1, curPrice + add(i, j));
                vis[i][j] = false;
                checkVis(i, j);
            }
        }
    }

    public static boolean isVis(int i, int j) {
        for (int[] cur : dir) {
            if (vis[i + cur[0]][j + cur[1]]) {
                return true;
            }
        }
        return false;
    }

    public static void checkVis(int i, int j) {
        for (int[] cur : dir) {
            vis[i + cur[0]][j + cur[1]] = !vis[i + cur[0]][j + cur[1]];
        }
    }

    public static int add(int i, int j) {
        int sum = board[i][j];
        for (int[] cur : dir) {
            sum += board[i + cur[0]][j + cur[1]];
        }
        return sum;
    }
}
