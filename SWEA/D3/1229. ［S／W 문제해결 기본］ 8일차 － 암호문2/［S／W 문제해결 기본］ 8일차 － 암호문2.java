import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();
		
		for(int i=1; i<=10; i++) {
			int N = Integer.parseInt(br.readLine());
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			List<String> list = new ArrayList<>();
			while(N-->0){
				list.add(st.nextToken());
			}
			
			int C = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			while(C-->0) {
				String command = st.nextToken();
				
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				if(command.equals("I")) {
					for(int j=0; j<y; j++) {
						list.add(x+j,st.nextToken());
					}
				}else {
					while(y-->0) {
						list.remove(x);
					}
				}
			}
			
			sb.append("#").append(i).append(" ");
			
			for(int j=0; j<10; j++) {
				sb.append(list.get(j)).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}

}
