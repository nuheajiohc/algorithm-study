import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static List<Long> nums = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<10; i++) {
			recursion(i, i);
		}

		Collections.sort(nums);
		
		if(N >= nums.size()) {
			System.out.println(-1);
		}else {
			System.out.println(nums.get(N));
		}
	}
	
	static void recursion(int k, long num) {
		nums.add(num);
		
		for(int i=0; i<k; i++) {
			recursion(i, num*10 + i);
		}
	}
}
