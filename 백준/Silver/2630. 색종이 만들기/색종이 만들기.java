import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  private static int N;
  private static int[][] paper;
  private static int white, blue;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    paper = new int[N][N];
    for(int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for(int j = 0; j < N; j++) {
        paper[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    recur(0,0,N);
    System.out.println(white);
    System.out.println(blue);
  }

  public static void recur(int x, int y, int n){
    if(n==0) return;
    int w=0;
    int b=0;
    for(int i=x; i<x+n; i++){
      for(int j=y; j<y+n; j++){
        if(paper[i][j]==1){
          b++;
        }else{
          w++;
        }
      }
    }

    if(w==0){
      blue++;
    }else if(b==0){
      white++;
    }else{
      recur(x,y,n/2);
      recur(x+n/2,y,n/2);
      recur(x,y+n/2,n/2);
      recur(x+n/2,y+n/2,n/2);
    }
  }
}
