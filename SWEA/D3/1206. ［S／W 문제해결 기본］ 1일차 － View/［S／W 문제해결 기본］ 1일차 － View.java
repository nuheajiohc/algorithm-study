import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringBuilder sb = new StringBuilder();
    for (int tc = 1; tc <= 10; tc++) {
      int N = Integer.parseInt(br.readLine());
      int[] arr = new int[N];
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int i = 0; i < N; i++) {
        arr[i] = Integer.parseInt(st.nextToken());
      }

      int sum=0;
      for (int i = 2; i < N - 2; i++) {
        int max = Math.max(arr[i-2],arr[i-1]);
        max = Math.max(max,arr[i+1]);
        max = Math.max(max,arr[i+2]);
        if(max>arr[i]) continue;
        sum += arr[i]-max;
      }
      sb.append(String.format("#%d %d\n", tc, sum));
    }
    System.out.println(sb);
  }
}
