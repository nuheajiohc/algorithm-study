import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  private static int N, M;
  private static int[] arr;
  private static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    arr = new int[M];

    btk(0);
    System.out.println(sb);
  }

  public static void btk(int depth){
    if(depth == M){
      for(int num : arr){
        sb.append(num).append(" ");
      }
      sb.append("\n");
      return;
    }

    for(int i=1; i<=N; i++){
      arr[depth] = i;
      btk(depth+1);
    }
  }
}
