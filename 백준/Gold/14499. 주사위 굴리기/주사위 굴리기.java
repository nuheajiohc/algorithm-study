import java.io.*;
import java.util.*;

public class Main {
	
	private static int N, M, x, y, K;
	private static int[][] map;
	private static int[] commands;
	private static int[] dx = {0, 0, 0, -1, 1};
	private static int[] dy = {0, 1, -1, 0, 0};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		commands = new int[K];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<K; i++) {
			commands[i] = Integer.parseInt(st.nextToken());
		}
		
		
		Dice dice = new Dice();
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<K; i++) {
			int nx = x + dx[commands[i]];
			int ny = y + dy[commands[i]];
			if(nx<0 || nx>=N || ny<0 || ny>=M) continue;
			x=nx;
			y=ny;
			dice.rotate(commands[i]);
			if(map[x][y]==0) {
				map[x][y] = dice.getBottom();
			} else {
				dice.copy(map[x][y]);
				map[x][y] = 0;
			}
			
			sb.append(dice.getTop()).append("\n");
		}
		
		System.out.println(sb);
		
	}
	
	public static class Dice{
		List<Integer> we; //위 동 아래 서
		List<Integer> ns; //위 남 아래 북
		
		public Dice() {
			we = new LinkedList<>();
			ns = new LinkedList<>();
			for(int i=0; i<4; i++) {
				we.add(0);
				ns.add(0);
			}
		}
		
		public int getTop() {
			return we.get(0);
		}
		
		public int getBottom() {
			return we.get(2);
		}
		
		public void copy(int num) {
			we.set(2, num);
			ns.set(2, num);
		}
		
		public void rotate(int direction) {
			if(direction==1) {
				Collections.rotate(we, -1);
				ns.set(0, we.get(0));
				ns.set(2, we.get(2));
			}else if(direction==2) {
				Collections.rotate(we, 1);
				ns.set(0, we.get(0));
				ns.set(2, we.get(2));
			}else if(direction==3) {
				Collections.rotate(ns, 1);
				we.set(0, ns.get(0));
				we.set(2, ns.get(2));
			}else{
				Collections.rotate(ns, -1);
				we.set(0, ns.get(0));
				we.set(2, ns.get(2));
			}
		}
	}
}
