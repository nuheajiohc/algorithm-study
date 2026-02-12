import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int N, M, cnt;
	static int[][] city;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc=1; tc<=TC; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			cnt = 0;
			city = new int[N][N];
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					city[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int k=1; k<=N+2; k++) {
				int cost = k*k + (k-1)*(k-1);
				for(int i=0; i<N; i++) {
					for(int j=0; j<N; j++) {
						manhattan(i,j,k,cost);
					}
				}
			}
			
			sb.append("#").append(tc).append(" ").append(cnt).append("\n");
		}
		System.out.println(sb);
	}

	static void manhattan(int x, int y, int k, int cost) {
		int tmpCnt = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				int dist = Math.abs(x-i)+Math.abs(y-j);
				if(dist<k) {
					if(city[i][j]==1) tmpCnt++;
				}
			}
		}
		
		if(tmpCnt*M >= cost) {
			cnt = Math.max(cnt, tmpCnt);			
		}
	}
}
