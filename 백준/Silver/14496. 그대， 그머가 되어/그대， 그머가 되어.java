import com.sun.jdi.ArrayReference;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  private static List<Integer>[] adj;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int a = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    adj = new ArrayList[n + 1];
    for (int i = 1; i <= n; i++) {
      adj[i] = new ArrayList<>();
    }

    while (m-- > 0) {
      st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());
      adj[u].add(v);
      adj[v].add(u);
    }
    System.out.println(bfs(a, b, n));
  }

  private static int bfs(int a, int b, int n) {
    if(a==b) return 0;
    int[] vis = new int[n + 1];
    Queue<Integer> q = new ArrayDeque<>();
    q.offer(a);
    vis[a] = 1;
    while (!q.isEmpty()) {
      int cur = q.poll();
      for (int next : adj[cur]) {
        if (vis[next] > 0) {
          continue;
        }
        vis[next] = vis[cur] + 1;
        q.offer(next);
        if (next == b) {
          return vis[next]-1;
        }
      }
    }
    return -1;

  }
}

