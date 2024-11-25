import java.io.*;
import java.util.*;

public class Main {

  private static int N,L,R;
  private static int[][] board;
  private static int[][] vis;
  private static final int CHECK = 2;
  private static final int VISITED = 1;
  private static final int UN_VISITED = 0;
  private static final int END = -1;
  private static int[] dx = {0,1,0,-1};
  private static int[] dy = {1,0,-1,0};
  public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      N = Integer.parseInt(st.nextToken());
      L = Integer.parseInt(st.nextToken());
      R = Integer.parseInt(st.nextToken());

      board = new int[N][N];
      for(int i=0; i<N; i++){
        st = new StringTokenizer(br.readLine());
        for(int j=0; j<N; j++){
          board[i][j] = Integer.parseInt(st.nextToken());
        }
      }

      int count=0;
      while(true){
        if(!canMove()) break;
        move();          
        count++;
      }
      System.out.println(count);
  }

  public static boolean canMove(){
    for(int i=0; i<N; i++){
      for(int j=0; j<N; j++){
        for(int dir=0; dir<2; dir++){
          int nx = i+dx[dir];
          int ny = j+dy[dir];
          if(isOutOfRange(nx,ny)) continue;
          int value = Math.abs(board[nx][ny]-board[i][j]);
          if(value>=L && value<=R) return true;
        }
      }
    }
    return false;
  }

  public static void move(){
    vis = new int[N][N];
    for(int i=0; i<N; i++){
      for(int j=0; j<N; j++){
        if(vis[i][j]!=UN_VISITED) continue;
        
        Queue<Point> q = new ArrayDeque<>();
        q.offer(new Point(i,j));
        vis[i][j] = VISITED;
        int isZero=0;
        while(!q.isEmpty()){
          Point p = q.poll();
          for(int dir=0; dir<4; dir++){
            int nx = p.x+dx[dir];
            int ny = p.y+dy[dir];
            if(isOutOfRange(nx,ny)) continue;
            if(vis[nx][ny]!=UN_VISITED) continue;
            int value = Math.abs(board[p.x][p.y]-board[nx][ny]);
            if(value<L || value>R) continue;
            isZero++;
            vis[nx][ny]=VISITED;
            q.offer(new Point(nx,ny));
          }
        }
        if(isZero>0){
          bfs(i,j);
        }else{
          vis[i][j]=UN_VISITED;
        }
      }
    }
  }

  public static void bfs(int x, int y){
      Queue<Point> q = new ArrayDeque<>();
      q.offer(new Point(x,y));
      vis[x][y]=CHECK;
      int count=1;
      int sum=board[x][y];
      while(!q.isEmpty()){
        Point p = q.poll();
        for(int dir=0; dir<4; dir++){
          int nx = p.x + dx[dir];
          int ny = p.y + dy[dir];
          if(isOutOfRange(nx,ny)) continue;
          if(vis[nx][ny]!=VISITED) continue;
          vis[nx][ny]=CHECK;
          count++;
          sum+=board[nx][ny];
          q.offer(new Point(nx,ny));
        }
      }
      int result = sum/count;

      q.offer(new Point(x,y));
      vis[x][y]=END;
      board[x][y]=result;
      while(!q.isEmpty()){
        Point p = q.poll();
        for(int dir=0; dir<4; dir++){
          int nx=p.x+dx[dir];
          int ny=p.y+dy[dir];
          if(isOutOfRange(nx,ny)) continue;
          if(vis[nx][ny]!=CHECK) continue;
          vis[nx][ny]=END;
          board[nx][ny]=result;
          q.offer(new Point(nx,ny));
        }
      }
  }
  
  public static boolean isOutOfRange(int x, int y){
    return x<0 || x>=N || y<0 || y>=N;
  }

  public static class Point{
    int x;
    int y;

    Point(int x, int y){
      this.x=x;
      this.y=y;
    }
  }
}
