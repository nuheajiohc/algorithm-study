import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  private static int N;
  private static char[][] board;
  private static int[] dx= {1,0};
  private static int[] dy= {0,1};
  private static int max;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    board = new char[N][N];
    for(int i=0; i<N; i++) {
      board[i] = br.readLine().toCharArray();
    }
    check();
    for(int i=0; i<N; i++) {
      for(int j=0; j<N; j++) {
        for(int dir=0; dir<2; dir++){
          int nextX = i+dx[dir];
          int nextY = j+dy[dir];
          if(nextY>=N || nextX>=N) continue;
          char temp = board[nextX][nextY];
          board[nextX][nextY] = board[i][j];
          board[i][j] = temp;
          check();
          board[i][j] = board[nextX][nextY];
          board[nextX][nextY] = temp;
        }
      }
    }
    System.out.println(max);
  }

  private static void check(){
    int temp=0;
    char cur;
    for(int i=0; i<N; i++){
      cur = board[i][0];
      for(int j=0; j<N; j++){
        if(cur==board[i][j]){
          temp++;
        }else{
          cur=board[i][j];
          temp=1;
        }
        max=Math.max(max,temp);
      }
      temp=0;
    }
    for(int i=0; i<N; i++){
      cur = board[0][i];
      for(int j=0; j<N; j++){
        if(cur==board[j][i]){
          temp++;
        }else{
          cur=board[j][i];
          temp=1;
        }
        max=Math.max(max,temp);
      }
      temp=0;
    }
  }
}
