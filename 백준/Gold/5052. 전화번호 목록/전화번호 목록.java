import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static String[] arr;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int TC = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= TC; tc++) {
			N = Integer.parseInt(br.readLine());
			
			arr = new String[N];
			for(int i=0; i<N; i++) {
				arr[i] = br.readLine();
			}
			
			Arrays.sort(arr);
			boolean canCall = true;
			for(int i=1; i<N; i++) {
				if(contains(arr[i-1], arr[i])) {
					canCall = false;
					break;
				}
			}
			
			if(canCall) {
				sb.append("YES").append("\n");
			}else {
				sb.append("NO").append("\n");
			}
		}
		System.out.println(sb);
	}
	
	static boolean contains(String prev, String next) {
		return next.startsWith(prev);
	}

}
