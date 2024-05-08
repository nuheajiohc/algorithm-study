import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    // input
    private static BufferedReader br;

    // variables
    private static int N, M, max;
    private static int[] counts;
    private static boolean[][] isVisited;
    private static List<List<Integer>> adjList;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() throws IOException {
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            BFS(i);
        }

        for (int i = 1; i <= N; i++) {
            if (counts[i] == max) {
                sb.append(i).append(' ');
            }
        }

        return sb.toString();
    } // End of solve()

    private static void BFS(int node) {
        ArrayDeque<Integer> que = new ArrayDeque<>();

        que.offer(node);

        while (!que.isEmpty()) {
            int cur = que.poll();

            if (isVisited[node][cur]) continue;
            isVisited[node][cur] = true;
            counts[node]++;

            for (int next : adjList.get(cur)) {
                if (isVisited[node][next]) continue;

                if (next > node) que.offer(next);
                else {
                    for (int i = 1; i <= N; i++) {
                        if (isVisited[node][i]) continue;
                        if (isVisited[next][i]) {
                            isVisited[node][i] = true;
                            counts[node]++;
                        }
                    }
                }
            }
        }

        max = Math.max(max, counts[node]);
    } // End of BFS()

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        max = 0;
        isVisited = new boolean[N + 1][N + 1];
        adjList = new ArrayList<>();
        counts = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adjList.get(b).add(a);
        }

    } // End of input()
} // End of Main class