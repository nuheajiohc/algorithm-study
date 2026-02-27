import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		List<Integer> minusOrZero = new ArrayList<>();
		List<Integer> plus = new ArrayList<>();
		
		int sum = 0;
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(br.readLine());
			if(num<=0) minusOrZero.add(num);
			else if(num==1) sum+=1;
			else plus.add(num);
		}
		
		Collections.sort(minusOrZero);
		Collections.sort(plus, Comparator.reverseOrder());
			
		int size = minusOrZero.size();
		for(int i=0; i<size; i+=2) {
			if(i+1<size) {
				sum+=minusOrZero.get(i)*minusOrZero.get(i+1);
			}else {
				sum+=minusOrZero.get(i);
			}
		}
		
		size = plus.size();
		for(int i=0; i<size; i+=2) {
			if(i+1<size) {
				sum+=plus.get(i)*plus.get(i+1);
			}else {
				sum+=plus.get(i);
			}
		}
		System.out.println(sum);
	}

}
