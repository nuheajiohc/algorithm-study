import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		Lecture[] lectures = new Lecture[N];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			lectures[i] = new Lecture(s,e);
		}
		
		Arrays.sort(lectures, (l1, l2)->{
			if(l1.s == l2.s) {
				return l1.e-l2.e;
			}
			return l1.s - l2.s;
		});
		
		
		PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->a-b); 
		
		int cnt = 1;
		pq.offer(lectures[0].e);
		for(int i=1; i<N; i++) {
			if(pq.peek()<=lectures[i].s) {
				pq.poll();
			}else{
				cnt++;
			}
			pq.offer(lectures[i].e);
		}
		
		System.out.println(cnt);
	}
	
	static class Lecture {
		int s;
		int e;
		
		Lecture(int s, int e){
			this.s = s;
			this.e = e;
		}
	}

}
