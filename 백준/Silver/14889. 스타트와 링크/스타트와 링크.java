import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static boolean[] vis;
    static int[][] ability;
    static int N;
    static int minValue = Integer.MAX_VALUE;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        ability = new int[N][];
        vis = new boolean[N];
        for (int i = 0; i < N; i++) {
            ability[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        select(0, 0);
        System.out.println(minValue);
    }

    public static void select(int depth, int k) {
        if (depth == N/2) {
            minValue = Math.min(minValue, check());
            return;
        }

        for (int i = k; i < N; i++) {
            if (depth == 0 && k == N / 2) {
                return;
            }
            vis[k] = true;
            select(depth + 1, i + 1);
            vis[k] = false;
        }
    }

    public static int check() {
        int sum=0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(vis[i] && vis[j])
                    sum+=ability[i][j];
                if(!vis[i] && !vis[j])
                    sum-=ability[i][j];
            }
        }
        return Math.abs(sum);
    }
}
