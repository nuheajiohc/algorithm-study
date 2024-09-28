import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class Main {

  private static int N, M;
  private static int[] arr;
  private static boolean[] used;
  private static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    arr = new int[M];
    used = new boolean[N+1];
    btk(0);
    System.out.println(sb);
  }

  public static void btk(int depth){
    if(depth == M){
      for(int i : arr){
        sb.append(i).append(" ");
      }
      sb.append("\n");
      return;
    }

    for(int i=1; i<=N; i++){
      if(used[i]) continue;
      used[i] = true;
      arr[depth]= i;
      btk(depth+1);
      used[i] = false;
    }
  }
}
