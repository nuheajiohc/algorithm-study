import java.io.*;
import java.util.*;

public class Main {
	
	static int N,M,size;
	static int[][] city, chicken;
	static boolean[] used;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		chicken = new int[13][2];
		city = new int[N][N];
		used = new boolean[13];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				city[i][j] = Integer.parseInt(st.nextToken());
				
				if(city[i][j]==2) {
					chicken[size++] = new int[] {i,j};
				}
			}
		}
		
		permutation(0,0);
		System.out.println(min);
	}
	
	static void permutation(int depth, int k) {
		if(depth==M) {
			findMin();
			return;
		}
		
		for(int i=k; i<size; i++) {
			used[i] = true;
			permutation(depth+1, i+1);
			used[i] = false;
		}
	}
	
	static void findMin() {
		int value = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(city[i][j]==1) {
					value += getMinDistance(i,j);
				}
			}
		}
		min = Math.min(min, value);
	}
	
	static int getMinDistance(int x, int y) {
		int tmp = Integer.MAX_VALUE;
		for(int i=0; i<size; i++) {
			if(!used[i]) continue;
			tmp = Math.min(tmp, Math.abs(x-chicken[i][0])+ Math.abs(y-chicken[i][1]));
		}
		return tmp;
	}
}
