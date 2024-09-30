import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());
    int[] arr = new int[N];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    int[] sum = new int[N-K+1];

    for(int i=0; i<K; i++){
      sum[0]+=arr[i];
    }

    for(int i=1; i<N-K+1; i++){
      sum[i]=arr[i+K-1]+sum[i-1]-arr[i-1];
    }
    int max=Integer.MIN_VALUE;
    for(int i=0;i<N-K+1; i++){
      max=Math.max(max,sum[i]);
    }
    System.out.println(max);
  }
}
