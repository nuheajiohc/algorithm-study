import java.io.*;
import java.util.*;

public class Main {
    static int[] dp;
    static int[] parent;
    static ArrayList<ArrayList<Integer>> list;
    static List<Integer> order; 

    public static void main(String[] args) throws IOException {
        StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        st.nextToken(); int n = (int)st.nval;
        st.nextToken(); int r = (int)st.nval;
        st.nextToken(); int q = (int)st.nval;

        list = new ArrayList<>();
        for (int i = 0; i <= n; i++) list.add(new ArrayList<>());

        for (int i = 0; i < n - 1; i++) {
            st.nextToken(); int u = (int)st.nval;
            st.nextToken(); int v = (int)st.nval;
            list.get(u).add(v);
            list.get(v).add(u);
        }

        dp = new int[n + 1];
        parent = new int[n + 1];
        order = new ArrayList<>();
        
        bfs(r, n);

        Arrays.fill(dp, 1);
        
        for (int i = order.size() - 1; i >= 0; i--) {
            int cur = order.get(i);
            int p = parent[cur];
            if (p != 0) {
                dp[p] += dp[cur];
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            st.nextToken();
            int num = (int)st.nval;
            sb.append(dp[num]).append("\n");
        }
        System.out.print(sb);
    }

    static void bfs(int start, int n) {
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[n + 1];

        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            order.add(cur); 

            for (int next : list.get(cur)) {
                if (!visited[next]) {
                    visited[next] = true;
                    parent[next] = cur;
                    queue.offer(next);
                }
            }
        }
    }
}