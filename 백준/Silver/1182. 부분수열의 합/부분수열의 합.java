import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  private static int count=0;
  private static int[] arr;
  private static int N,S;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    S = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());
    arr = new int[N];
    for(int i=0; i<N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    if(S==0) count=-1;
    permutation(0,0);
    System.out.println(count);
  }

  public static void permutation(int depth, int sum){
    if(depth == N){
      if(sum ==S) count++;
      return;
    }

    permutation(depth+1, sum+arr[depth]);
    permutation(depth+1, sum);
  }
}
