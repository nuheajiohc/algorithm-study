import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringBuilder sb = new StringBuilder();
    for(int tc=1; tc<=10; tc++){
      br.readLine();
      int max=0;
      int[][] arr = new int[100][100];
      for(int i=0; i<100; i++){
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int j=0; j<100; j++){
          arr[i][j] = Integer.parseInt(st.nextToken());
        }
      }

      for(int i=0; i<100; i++){
        int temp=0;
        for(int j=0; j<100; j++){
          temp+=arr[i][j];
        }
        max =Math.max(max,temp);
      }

      for(int i=0; i<100; i++){
        int temp=0;
        for(int j=0; j<100; j++){
          temp+=arr[j][i];
        }
        max =Math.max(max,temp);
      }
      int temp=0;
      for(int i=0; i<100; i++){
        temp+=arr[i][i];
      }
      max =Math.max(max,temp);
      temp=0;
      for(int i=0; i<100; i++){
        temp+=arr[i][99-i];
      }
      max = Math.max(max,temp);
      sb.append(String.format("#%d %d%n",tc, max));
    }

    System.out.println(sb);
  }
}
