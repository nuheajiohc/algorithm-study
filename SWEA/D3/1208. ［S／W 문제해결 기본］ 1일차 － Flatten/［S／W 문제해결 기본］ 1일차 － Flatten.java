import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringBuilder sb = new StringBuilder();
    for (int tc = 1; tc <= 10; tc++) {
      int dump = Integer.parseInt(br.readLine());
      StringTokenizer st = new StringTokenizer(br.readLine());
      int[] arr = new int[100];
      for(int i=0; i<100; i++){
        arr[i] = Integer.parseInt(st.nextToken());
      }

      for(int i=0; i<dump; i++){
        int minIdx=0;
        int maxIdx=0;
        for(int j=0; j<100; j++){
          if(arr[j]<arr[minIdx]){
            minIdx = j;
          }
          if(arr[j]>arr[maxIdx]){
            maxIdx = j;
          }
        }
        arr[minIdx]++;
        arr[maxIdx]--;
      }
      int min=101;
      int max=0;
      for(int i=0; i<100; i++){
        if(arr[i]>max) max = arr[i];
        if(arr[i]<min) min = arr[i];
      }
      sb.append(String.format("#%d %d%n", tc, max-min));
    }
    System.out.println(sb);
  }
}
