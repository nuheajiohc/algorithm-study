import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());

    StringBuilder sb = new StringBuilder();

    for(int i=1; i<=T; i++){
      int N = Integer.parseInt(br.readLine());
      sb.append("#").append(N).append(" ");
      int[] arr = new int[101];
      StringTokenizer st = new StringTokenizer(br.readLine());
      while(st.hasMoreTokens()){
        arr[Integer.parseInt(st.nextToken())]++;
      }
      int max=0;
      int score=0;
      for(int j=0; j<101; j++){
        if(max<=arr[j]){
          max=arr[j];
          score=j;
        }
      }
      sb.append(score).append("\n");
    }
    System.out.println(sb);
  }
}
