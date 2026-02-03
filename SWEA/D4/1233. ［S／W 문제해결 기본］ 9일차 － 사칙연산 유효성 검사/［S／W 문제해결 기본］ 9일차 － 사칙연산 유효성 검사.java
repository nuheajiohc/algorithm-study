import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		for(int t=1; t<=10; t++) {
			
			sb.append("#").append(t).append(" ");
			int N = Integer.parseInt(br.readLine());
			
			boolean[] arr = new boolean[N+1];
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int vertex = Integer.parseInt(st.nextToken());
				String first = st.nextToken();
				
				while(st.hasMoreTokens()) {
					st.nextToken();
				}
				
				if(isNum(first)) {
					arr[vertex] = true;
				}
			}
			
			if(N%2==0) {
				sb.append(0).append("\n");
				continue;
			}
			
			if(possible(N, arr)) {
				sb.append(1);
			}else {
				sb.append(0);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	public static boolean possible(int N, boolean[] arr) {
		for(int i=1; i<=N/2; i++) {
			if(arr[i]) {
				return false;
			}
		}
		
		for(int i=(N/2)+1; i<=N; i++) {
				if(!arr[i]) {
					return false;
				}
		}
		return true;
	}
	
	public static boolean isNum(String target) {
		return !(target.equals("*") || target.equals("/") || target.equals("+") || target.equals("-"));
	}

}
