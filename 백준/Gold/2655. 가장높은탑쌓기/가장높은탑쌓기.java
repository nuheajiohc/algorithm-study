import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static Brick[] bricks;
	static int[] dp, prev;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		bricks = new Brick[N];
		dp = new int[N];
		prev = new int[N];
		Arrays.fill(prev, -1);
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int area = Integer.parseInt(st.nextToken());
			int height = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			bricks[i] = new Brick(i + 1, area, height, weight);
		}

		Arrays.sort(bricks, (a, b) -> Integer.compare(b.area, a.area));

		int maxIdx = 0;
		for (int i = 0; i < N; i++) {
			dp[i] = bricks[i].height;
			for (int j = 0; j < i; j++) {
				if (bricks[i].weight > bricks[j].weight) continue;

				if(dp[j] + bricks[i].height > dp[i]) {
					dp[i] = dp[j] + bricks[i].height;
					prev[i] = j;
				}
			}
			
			if(dp[maxIdx] < dp[i]) {
				maxIdx = i;
			}
		}
		
		Deque<Integer> stack = new ArrayDeque<>();
		int cur = maxIdx;
		while(cur!=-1) {
			stack.offerLast(bricks[cur].idx);
			cur = prev[cur];
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(stack.size()).append("\n");
		while(!stack.isEmpty()) {
			sb.append(stack.pollFirst()).append("\n");
		}
		System.out.println(sb);

	}

	static class Brick {
		int idx, area, height, weight;

		Brick(int idx, int area, int height, int weight) {
			this.idx = idx;
			this.area = area;
			this.height = height;
			this.weight = weight;
		}
	}

}
