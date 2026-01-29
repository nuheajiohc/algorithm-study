import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] prev = new int[1000001];
	static int[] next = new int[1000001];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());

		int first = Integer.parseInt(st.nextToken());
		int current = first;

		for (int i = 1; i < N; i++) {
			int value = Integer.parseInt(st.nextToken());

			next[current] = value;
			prev[value] = current;

			current = value;
		}

		next[current] = first;
		prev[first] = current;

		StringBuilder sb = new StringBuilder();

		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			int i = Integer.parseInt(st.nextToken());

			if (command.equals("BN")) {
				int j = Integer.parseInt(st.nextToken());

				sb.append(next[i]).append("\n");

				int originalNext = next[i];

				prev[j] = i;
				next[j] = originalNext;

				next[i] = j;
				prev[originalNext] = j;

			} else if (command.equals("BP")) {
				int j = Integer.parseInt(st.nextToken());

				sb.append(prev[i]).append("\n");

				int originalPrev = prev[i];

				prev[j] = originalPrev;
				next[j] = i;

				next[originalPrev] = j;
				prev[i] = j;

			} else if (command.equals("CN")) {
				int target = next[i];
				sb.append(target).append("\n");

				int newNext = next[target];

				next[i] = newNext;
				prev[newNext] = i;

			} else if (command.equals("CP")) {
				int target = prev[i];
				sb.append(target).append("\n");

				int newPrev = prev[target];

				next[newPrev] = i;
				prev[i] = newPrev;
			}
		}

		System.out.println(sb);
	}
}
