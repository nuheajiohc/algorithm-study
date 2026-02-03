import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int s = 0;
		int e = N-1;
		int sum = arr[s]+arr[e];
		int t1 = s;
		int t2 = e;
		while(s<e) {
			if(Math.abs(arr[s]+arr[e])<Math.abs(sum)) {
				t1 = s;
				t2 = e;
				sum = arr[s]+arr[e];
			}
			
			if(arr[s]+arr[e]<0) {
				s++;
			}else {
				e--;
			}
		}
		System.out.println(arr[t1] + " " + arr[t2]);
	}

}
