import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	static int N, M;
	static int[] p;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		p = new int[N];
		Arrays.fill(p, -1);
		
		int order = 0;
		for(int i=1; i<=M; i++){
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			boolean canUnion = union(u, v);
			if(!canUnion && order==0) {
				order = i;
			}
		}
		System.out.println(order);
	}
	
	static int find(int u) {
		if(p[u]<0) return u;
		
		return p[u] = find(p[u]);
	}
	
	static boolean union(int u, int v) {
		u = find(u);
		v = find(v);
		
		if(u==v) return false;
		
		if(p[u] < p[v]) {
			p[u] += p[v];
			p[v] = u;
		}else {
			p[v] += p[u];
			p[u] = v;
		}
		return true;
	}

}
