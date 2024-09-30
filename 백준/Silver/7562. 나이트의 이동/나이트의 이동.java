import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  private static int[] dx ={1,2,1,2,-1,-1,-2,-2};
  private static int[] dy = {2,1,-2,-1,2,-2,-1,1};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());

    StringBuilder sb = new StringBuilder();
    while(T-->0){
      int N  = Integer.parseInt(br.readLine());
      StringTokenizer st = new StringTokenizer(br.readLine());
      int cur_x = Integer.parseInt(st.nextToken());
      int cur_y = Integer.parseInt(st.nextToken());

      st = new StringTokenizer(br.readLine());
      int next_x = Integer.parseInt(st.nextToken());
      int next_y = Integer.parseInt(st.nextToken());

      int[][] vis = new int[N][N];
      vis[cur_x][cur_y] = 1;

      Queue<Point> q = new ArrayDeque<>();
      q.add(new Point(cur_x,cur_y));

      while(!q.isEmpty()){
        Point p = q.poll();
        for(int dir=0; dir<8; dir++){
          int nx = p.x + dx[dir];
          int ny = p.y + dy[dir];
          if(nx<0 || ny<0 || nx>=N || ny>=N || vis[nx][ny]>0) continue;
          vis[nx][ny] = vis[p.x][p.y] + 1;
          q.add(new Point(nx,ny));
        }
      }
      sb.append(vis[next_x][next_y]-1).append("\n");
    }
    System.out.println(sb);
  }

  public static class Point{
    int x;
    int y;

    public Point(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }
}
