import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int count = 0;
		int sum = 0;
		int s = 0;
		int e = 0;
		while(true) {
			if(sum>=M) {
				sum-=arr[s];
				s++;
			} else if(e==N) {
				break;
			} else {
				sum+=arr[e];
				e++;
			}
			if(sum==M) count++;
		}
		System.out.println(count);
	}
}
