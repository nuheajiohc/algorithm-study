import java.io.*;
import java.util.*;

public class Main {

	static int N, K;
	static int ADJUST = 1_000_000_000;
	static Map<Integer, TreeSet<Integer>> diag1, diag2; // / \

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		char[] cmd = br.readLine().toCharArray();

		diag1 = new HashMap<>();
		diag2 = new HashMap<>();

		int startX = -1;
		int startY = -1;

		while (N-- > 0) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			if (startX == -1 && startY == -1) {
				startX = x;
				startY = y;
			}

			int ru = x + y;
			int rd = x - y + ADJUST;

			if (!diag1.containsKey(ru)) {
				diag1.put(ru, new TreeSet<>());
			}

			if (!diag2.containsKey(rd)) {
				diag2.put(rd, new TreeSet<>());
			}

			TreeSet<Integer> xSet1 = diag1.get(ru);
			TreeSet<Integer> xSet2 = diag2.get(rd);
			
			xSet1.add(x);
			xSet2.add(x);
		}

		TreeSet<Integer> xSet2;
		TreeSet<Integer> xSet1;
		int rd;
		int ru;
		for (char c : cmd) {
			rd = startX - startY + ADJUST;
			ru = startX + startY;
			xSet2 = diag2.get(rd);
			xSet1 = diag1.get(ru);
			Integer target = null;
			if (c == 'A') {
				target = xSet2.higher(startX);
				if (target != null) {
					xSet1.remove(startX);
					xSet2.remove(startX);
					startX = target;
					startY = startX - rd + ADJUST;
				}
			} else if (c == 'B') {
				target = xSet1.higher(startX);
				if (target != null) {
					xSet1.remove(startX);
					xSet2.remove(startX);
					startX = target;
					startY = ru - startX;
				}
			} else if (c == 'C') {
				target = xSet1.lower(startX);
				if (target != null) {
					xSet1.remove(startX);
					xSet2.remove(startX);
					startX = target;
					startY = ru - startX;
				}
			} else {
				target = xSet2.lower(startX);
				if (target != null) {
					xSet1.remove(startX);
					xSet2.remove(startX);
					startX = target;
					startY = startX - rd + ADJUST;
				}
			}
		}
		System.out.println(startX + " " + startY);
	}
}
