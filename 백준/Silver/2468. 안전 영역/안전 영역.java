import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

  private static int[] dx = {0,0,1,-1};
  private static int[] dy = {1,-1,0,0};
  private static int N;
  private static int[][] area;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    area = new int[N][N];
    for(int i = 0; i < N; i++){
      StringTokenizer st = new StringTokenizer(br.readLine());
      for(int j = 0; j < N; j++){
        area[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    int max=0;
    for(int h=0; h<=100; h++){
      max = Math.max(max, bfs(h));
    }
    System.out.println(max);
  }

  private static int bfs(int h){
    boolean[][] vis = new boolean[N][N];

    int count =0;
    for(int i=0; i<N; i++){
      for(int j=0; j<N; j++){
        if(vis[i][j] || area[i][j]<=h) continue;
        count++;
        vis[i][j] = true;
        Deque<Point> queue = new ArrayDeque<>();
        queue.offer(new Point(i,j));

        while(!queue.isEmpty()){
          Point point = queue.poll();
          for(int dir=0; dir<4; dir++){
            int nx = point.x + dx[dir];
            int ny = point.y + dy[dir];
            if(isOutOfRange(nx, ny)) continue;
            if(vis[nx][ny] || area[nx][ny]<=h) continue;
            vis[nx][ny] =true;
            queue.offer(new Point(nx,ny));
          }
        }
      }
    }
    return count;
  }

  private static class Point{
    int x;
    int y;

    public Point(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  private static boolean isOutOfRange(int x, int y){
    return x<0 || x>=N || y<0 || y>=N;
  }
}
