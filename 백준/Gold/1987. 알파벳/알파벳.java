import java.io.*;
import java.util.*;

public class Main {

  private static int R,C;
  private static char[][] board;
  private static boolean[] used;
  private static boolean[][] vis;
  private static int[] dx = {0,0,1,-1};
  private static int[] dy = {1,-1,0,0};
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    R = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());

    board = new char[R][C];
    for(int i=0; i<R; i++){
      board[i] = br.readLine().toCharArray();
    }

    vis = new boolean[R][C];
    used = new boolean[26];
    int count= btk(0,0,0);
    System.out.println(count);

  }

  public static int btk(int tempCount, int x, int y){
    if(vis[x][y]||used[board[x][y]-'A']){
      return tempCount;
    }
    vis[x][y]=true;
    used[board[x][y]-'A']=true;
    int count = tempCount+1;
    for(int dir=0; dir<4; dir++){
      int nx = x+dx[dir];
      int ny = y+dy[dir];
      if(isOutOfRange(nx,ny)) continue;
      count = Math.max(count, btk(tempCount+1, nx, ny));
    }
    vis[x][y]=false;
    used[board[x][y]-'A']=false;
    return count;
  }

  public static boolean isOutOfRange(int x, int y){
    return x<0 || x>=R || y<0 || y>=C;
  }
}
