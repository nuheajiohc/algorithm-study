import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static int[] order;
	static int[][] record;
	static boolean[] used;
	static int maxResult = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		order = new int[9];
		order[3] = 0;
		used = new boolean[9];
		used[0] = true;
		
		record = new int[N][9];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<9; j++) {
				record[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		permutation(0);
		
		System.out.println(maxResult);
	}
	
	static int find() {
		int idx = 0;
		Queue<Integer> queue = new ArrayDeque<>();
		int totalScore = 0;
		for(int i=0; i<N; i++) {
			int out = 0;
			while(true) {
				int result = record[i][order[idx]];
				idx = (idx+1) % 9;
				
				if(result != 0) {
					int size = queue.size();
					while(size-->0) {
						int score = queue.poll();
						if(result + score >= 4) {
							totalScore++;
						}else {
							queue.offer(result+score);
						}
					}
					
					if(result<4) {
						queue.offer(result);
					}else if(result==4) {
						totalScore++;
					}
				}else {
					out++;
				}
				
				if(out==3) break;
			}
			queue.clear();
		}
		return totalScore;
	}
	
	static void permutation(int depth) {
		if(depth==9) {
			maxResult = Math.max(maxResult, find());
			return;
		}
		
		for(int i=1; i<9; i++) {
			if(used[i]) continue;
			if(depth==3) {
				permutation(depth+1);
				return;
			}
			used[i] = true;
			order[depth] = i;
			permutation(depth+1);
			used[i] = false;
		}
	}

}
