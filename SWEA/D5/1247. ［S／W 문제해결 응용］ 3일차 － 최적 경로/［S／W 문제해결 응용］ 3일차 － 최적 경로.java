import java.io.*;
import java.util.*;

public class Solution {

	static int N, minDist;
	static int[] company, house;
	static boolean[] visited;
	static int[][] customers;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int TC = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= TC; tc++) {
			N = Integer.parseInt(br.readLine());

			StringTokenizer st = new StringTokenizer(br.readLine());
			int companyX = Integer.parseInt(st.nextToken());
			int companyY = Integer.parseInt(st.nextToken());
			company = new int[] {companyX, companyY};
			
			int houseX = Integer.parseInt(st.nextToken());
			int houseY = Integer.parseInt(st.nextToken());
			house = new int[] { houseX, houseY};
			
			customers = new int[N][2];
			for (int i = 0; i < N; i++) {
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				customers[i] = new int[] { x, y };
			}

			minDist = Integer.MAX_VALUE;
			visited = new boolean[N];
			permutation(0, 0, company);
			
			sb.append("#").append(tc).append(" ").append(minDist).append("\n");
		}
		System.out.println(sb);

	}

	static void permutation(int depth, int dist, int[] prev) {
		if (depth == N) {
			dist += Math.abs(prev[0] - house[0]) + Math.abs(prev[1] - house[1]);
			minDist = Math.min(dist, minDist);
			return;
		}

		for (int i = 0; i < N; i++) {
			if (visited[i])
				continue;
			visited[i] = true;
			permutation(depth + 1, dist + Math.abs(prev[0] - customers[i][0]) + Math.abs(prev[1] - customers[i][1]),
					customers[i]);
			visited[i] = false;
		}
	}
}
