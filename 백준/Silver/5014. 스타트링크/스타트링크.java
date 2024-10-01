import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  private static int[] move;
  private static int F,S,G,U,D;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    F = Integer.parseInt(st.nextToken());
    S = Integer.parseInt(st.nextToken());
    G = Integer.parseInt(st.nextToken());
    U = Integer.parseInt(st.nextToken());
    D = Integer.parseInt(st.nextToken());
    move = new int[]{U,D*-1};
    bfs();
  }

  public static void bfs(){
    Queue<Integer> q = new ArrayDeque<>();
    int[] vis = new int[F+1];
    Arrays.fill(vis, -1);
    q.offer(S);
    vis[S] = 1;
    while(!q.isEmpty()){
      int cur = q.poll();
      for(int dir=0; dir<2; dir++){
        int nc = cur+move[dir];
        if(nc<1 || nc>F) continue;
        if(vis[nc]>0) continue;
        vis[nc] = vis[cur]+1;
        q.offer(nc);
      }
    }
    if(vis[G]>0){
      System.out.println(vis[G]-1);
    }else{
      System.out.println("use the stairs");
    }
  }
}
