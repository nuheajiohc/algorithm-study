import java.io.*;
import java.util.*;

public class Solution {
	
	private static List<Integer>[] lists;
	private static int K;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int t=1; t<=T; t++) {
			K = Integer.parseInt(br.readLine());
			
			lists = new ArrayList[4];
			for(int i=0; i<4; i++) {
				lists[i] = new ArrayList<>();
				
				StringTokenizer st = new StringTokenizer(br.readLine());
				while(st.hasMoreTokens()) {
					lists[i].add(Integer.parseInt(st.nextToken()));
				}
			}
			
			for(int i=0; i<K; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int num = Integer.parseInt(st.nextToken())-1;
				int dir = Integer.parseInt(st.nextToken());
				
				int[] rotate = new int[4];
				
				rotate[num] = dir;
				
				for(int j=num-1; j>=0; j--) {
					if (lists[j].get(2) != lists[j+1].get(6)) {
						rotate[j] = rotate[j+1] * (-1);
					} else {
						break;
					}
				}
				
				for(int j=num+1; j<4; j++) {
					if(lists[j].get(6) != lists[j-1].get(2)) {
						rotate[j] = rotate[j-1] * (-1);
					} else {
						break;
					}
				}
				
				for(int j=0; j<4; j++) {
					if(rotate[j]==0) continue;
					Collections.rotate(lists[j], rotate[j]);
				}
			}
			
			int sum = 0;
			for(int i=0; i<4; i++) {
				if(lists[i].get(0)==1) {
					sum += 1<<i;
				}
			}
			
			sb.append("#").append(t).append(" ").append(sum).append("\n");
		}
		
		System.out.println(sb);
	}

}
