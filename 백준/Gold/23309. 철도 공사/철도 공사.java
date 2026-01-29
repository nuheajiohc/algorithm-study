import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		Node[] nodes = new Node[1000001];
		
		Node root = new Node(Integer.parseInt(st.nextToken()));
		Node prev = root;
		nodes[prev.value] = prev;
		for(int i=1; i<N; i++) {
			Node cur = new Node(Integer.parseInt(st.nextToken()));
			nodes[cur.value] = cur;
			cur.prev = prev;
			prev.next = cur;
			prev = cur;
			
		}
		prev.next = root;
		root.prev = prev;
		
		StringBuilder sb = new StringBuilder();
		while(M-->0) {
			st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			int num = Integer.parseInt(st.nextToken());
			Node station = nodes[num];
			
			if(command.equals("BN")) {
				int cand = Integer.parseInt(st.nextToken());
				Node newStation  = new Node(cand);
				sb.append(station.next.value);
				Node nextStation = station.next;
				station.next = newStation;
				nextStation.prev = newStation;
				newStation.next = nextStation;
				newStation.prev = station;
				nodes[newStation.value]= newStation;
			}else if(command.equals("BP")) {
				int cand = Integer.parseInt(st.nextToken());
				Node newStation  = new Node(cand);
				sb.append(station.prev.value);
				Node prevStation = station.prev;
				station.prev = newStation;
				prevStation.next = newStation;
				newStation.prev = prevStation;
				newStation.next = station;
				nodes[newStation.value] = newStation;
			}else if(command.equals("CN")) {
				Node nextStation = station.next;
				sb.append(nextStation.value);
				Node nextNextStation = nextStation.next;
				station.next = nextNextStation;
				nextNextStation.prev = station;
			}else {
				Node prevStation = station.prev;
				sb.append(prevStation.value);
				Node prevPrevStation = prevStation.prev;
				station.prev = prevPrevStation;
				prevPrevStation.next = station;
			}
			sb.append("\n");
			
		}
		
		System.out.println(sb);
	}
	
	public static class Node{
		Node prev;
		int value;
		Node next;
		
		public Node(int value) {
			this.value = value;
		}
	}

}
