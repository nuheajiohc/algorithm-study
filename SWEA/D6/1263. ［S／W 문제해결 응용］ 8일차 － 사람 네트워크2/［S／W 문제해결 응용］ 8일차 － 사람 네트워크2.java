import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int tc=1; tc<=TC; tc++) {
			System.out.println(tc);
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());

			int[][] dist = new int[N][N];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					int value = Integer.parseInt(st.nextToken());
					if(value>0) {
						dist[i][j] = value;
					}else {
						dist[i][j] = 1000001;
					}
				}
			}

			for(int k=0; k<N; k++) {
				for(int i=0; i<N; i++) {
					for(int j=0; j<N; j++) {
						dist[i][j] = Math.min(dist[i][j], dist[i][k]+dist[k][j]);
					}
				}
			}
			
			int min = Integer.MAX_VALUE;
			for(int i=0; i<N; i++) {
				int sum = 0;
				for(int j=0; j<N; j++) {
					if(i==j || dist[i][j]>1000001) continue;
					sum += dist[i][j];
				}
				min = Math.min(min, sum);
			}
			
			sb.append("#").append(tc).append(" ").append(min).append("\n");
		}
		
		System.out.println(sb);
	}

}
