import java.io.*;
import java.util.*;

public class Solution {
	
	static int N;
	static int[][] room, stair;
	static List<int[]> people;
	static int minTime;
	static boolean[] selected;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int TC = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc=1; tc<=TC; tc++) {
			N = Integer.parseInt(br.readLine());
			room = new int[N][N];
			
			stair = new int[2][3];
			people = new ArrayList<>();
			
			int stairIdx = 0;
			
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					room[i][j] = Integer.parseInt(st.nextToken());
					
					if(room[i][j]>1) {
						stair[stairIdx++] = new int[] {i, j, room[i][j]};
					}else if(room[i][j]==1){
						people.add(new int[] {i, j, room[i][j]}); 
					}
				}
			}

			minTime = Integer.MAX_VALUE;
			
			selected = new boolean[people.size()];
			
			dfs(0);
			
			sb.append("#").append(tc).append(" ").append(minTime).append("\n");
		}
		System.out.println(sb);
	}
	
	static void dfs(int depth) {
		if(depth==people.size()) {
			minTime = Math.min(minTime, calTime());
			return;
		}
		selected[depth] = true;
		dfs(depth+1);
		
		selected[depth] = false;
		dfs(depth+1);
	}

	static int calTime() {
		List<Integer> stair1 = new ArrayList<>();
		List<Integer> stair2 = new ArrayList<>();
		
		for(int i=0; i<people.size(); i++) {
			if(selected[i]) {
				int dist = Math.abs(stair[0][0]-people.get(i)[0]) + Math.abs(stair[0][1]-people.get(i)[1]);
				stair1.add(dist);
			}else {
				int dist = Math.abs(stair[1][0]-people.get(i)[0]) + Math.abs(stair[1][1]-people.get(i)[1]);
				stair2.add(dist);
			}
		}
		
		int time1 = getStairFinishedTime(stair1, stair[0][2]);
		int time2 = getStairFinishedTime(stair2, stair[1][2]);
		
		return Math.max(time1, time2);
	}
	
	static int getStairFinishedTime(List<Integer> stair, int stairTime) {
		if(stair.isEmpty()) return 0; 
		
		Collections.sort(stair);
		
		int[] finishTime = new int[stair.size()];
		
		for(int i=0; i<stair.size(); i++) {
			int arrivalTime = stair.get(i);
			
			if(i<3) {
				finishTime[i] = arrivalTime + 1 + stairTime;
			}else {
				finishTime[i] = Math.max(finishTime[i-3], arrivalTime + 1) + stairTime;
			}
		}
		
		return finishTime[stair.size() - 1];
	}
}


 