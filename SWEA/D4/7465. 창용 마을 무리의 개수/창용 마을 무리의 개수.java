import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

	static int N, M;
	static int[] p;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int TC = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= TC; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			p = new int[N + 1];
			Arrays.fill(p, -1);

			while (M-- > 0) {
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());

				union(u, v);
			}

			int cnt = 0;
			for (int i = 1; i <= N; i++) {
				if (p[i] < 0)
					cnt++;
			}
			sb.append("#").append(tc).append(" ").append(cnt).append("\n");
		}
		System.out.println(sb);
	}

	static int find(int u) {
		if (p[u] < 0)
			return u;

		return p[u] = find(p[u]);
	}

	static boolean union(int u, int v) {
		u = find(u);
		v = find(v);

		if (u == v)
			return false;

		if (p[v] < p[u]) {
			p[v] += p[u];
			p[u] = v;
		} else {
			p[u] += p[v];
			p[v] = u;
		}

		return true;
	}
}
