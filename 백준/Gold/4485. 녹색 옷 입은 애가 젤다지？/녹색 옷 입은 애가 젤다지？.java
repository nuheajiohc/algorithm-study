import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringBuilder sb = new StringBuilder();

    int[] dx = {0,0,1,-1};
    int[] dy = {1,-1,0,0};

    int problem = 1;
    while(true){
      int N = Integer.parseInt(br.readLine());
      if(N==0) break;

      int[][] board = new int[N][N];
      for(int i=0; i<N; i++){
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int j=0; j<N; j++){
          board[i][j] = Integer.parseInt(st.nextToken());
        }
      }

      List<Node>[] adj = new ArrayList[N*N];
      for(int i=0; i<N*N; i++){
        adj[i] = new ArrayList<>();
      }

      for(int i=0; i<N; i++){
        for(int j=0; j<N; j++){
          for(int dir=0; dir<4; dir++){
            int nx = i+dx[dir];
            int ny = j+dy[dir];
            if(isOutOfRange(nx,ny, N)) continue;
            adj[i*N+j].add(new Node(nx*N+ny, board[nx][ny]));
          }
        }
      }

      PriorityQueue<Node> pq = new PriorityQueue<>((a,b)->a.weight-b.weight);
      int[] distance = new int[N*N];
      Arrays.fill(distance, 100000);
      distance[0]=board[0][0];
      pq.offer(new Node(0,board[0][0]));
      while(!pq.isEmpty()){
        Node cur = pq.poll();
        if(cur.weight != distance[cur.idx]) continue;
        for(Node next : adj[cur.idx]){
            if(distance[next.idx] <= distance[cur.idx]+next.weight) continue;          
            pq.offer(new Node(next.idx, next.weight+cur.weight));
            distance[next.idx]=cur.weight+next.weight;
        }
      }

      sb.append("Problem ").append(problem).append(": ").append(distance[N*N-1]).append("\n");
      problem++;
    }
    System.out.println(sb);
  }

  public static class Node{
    int idx;
    int weight;

    Node(int idx, int weight){
      this.idx = idx;
      this.weight = weight;
    }
  }

  public static boolean isOutOfRange(int x, int y, int n){
    return x<0 || x>=n || y<0 || y>=n;
  }
}
