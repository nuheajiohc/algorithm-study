import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	
	static int[] dx = {0, 0, -1, 1}, dy = {1, -1, 0, 0};
	static int[][] map = new int[4001][4001];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int tc=1; tc<=TC; tc++) {
			int N = Integer.parseInt(br.readLine());

			List<Atom> atoms = new ArrayList<>();
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int x = (Integer.parseInt(st.nextToken())+1000) * 2;
				int y = (Integer.parseInt(st.nextToken())+1000) * 2;
				int d = Integer.parseInt(st.nextToken());
				int k = Integer.parseInt(st.nextToken());
				atoms.add(new Atom(x, y, d, k));
				map[x][y] = k;
			}
			
			int totalSum = 0;
			
			while(!atoms.isEmpty()) {
				for(Atom atom : atoms) {
					map[atom.x][atom.y]=0;
					atom.move();
					if(atom.x<0 || atom.x>4000 || atom.y<0 || atom.y>4000) {
						atom.isDead = true;
						continue;
					}
					
					map[atom.x][atom.y]+=atom.k;
				}
				
				for(Atom atom : atoms) {
					if(atom.isDead) continue;
					if(map[atom.x][atom.y]>atom.k) {
						totalSum += atom.k;
						atom.isDead = true;
					}
				}
				
				for(Atom atom : atoms) {
					if(atom.x<0 || atom.x>4000 || atom.y<0 || atom.y>4000) continue;
					if(atom.isDead) {
						map[atom.x][atom.y] = 0;
					}
				}
				
				atoms.removeIf(a-> a.isDead);
			}
			
			sb.append("#").append(tc).append(" ").append(totalSum).append("\n");
		}
		System.out.println(sb);
	}

	static class Atom {
		int x;
		int y;
		int d;
		int k;
		boolean isDead;
		
		Atom(int x, int y, int d, int k){
			this.x=x;
			this.y=y;
			this.d=d;
			this.k=k;
		}
		
		void move(){
			this.x = x+dx[d];
			this.y = y+dy[d];
		}
	}
}
