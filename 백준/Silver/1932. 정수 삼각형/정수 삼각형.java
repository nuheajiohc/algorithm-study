import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    int[][] arr = new int[501][501];
    for(int i=1; i<=N; i++){
      StringTokenizer st = new StringTokenizer(br.readLine());
      for(int j=1; j<=i; j++){
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    for(int i=2; i<=N; i++){
      for(int j=1; j<=i; j++){
        arr[i][j] += Math.max(arr[i-1][j-1],arr[i-1][j]);
      }
    }

    int max=0;
    for(int i=1; i<=N; i++){
      max = Math.max(max, arr[N][i]);;
    }
    System.out.println(max);
  }
}
