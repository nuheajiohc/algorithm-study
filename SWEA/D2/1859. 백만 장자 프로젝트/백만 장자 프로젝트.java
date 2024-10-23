import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());

    for(int i=1; i<=T; i++) {
      int N = Integer.parseInt(br.readLine());
      StringTokenizer st = new StringTokenizer(br.readLine());
      int[] arr = new int[N];
      for(int j=0; j<N; j++) {
        arr[j] = Integer.parseInt(st.nextToken());
      }

      int max=arr[N-1];
      long result=0;
      for(int j=N-1; j>0; j--) {
        if(max>arr[j-1]){
          result+=max-arr[j-1];
        }else{
          max=arr[j-1];
        }
      }
      System.out.printf("#%d %d\n", i, result);
    }
  }
}
