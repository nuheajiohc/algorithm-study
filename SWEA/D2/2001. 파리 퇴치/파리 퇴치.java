import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());

    StringBuilder sb = new StringBuilder();
    for(int t=1; t<=T; t++) {
      sb.append("#").append(t).append(" ");
      StringTokenizer st = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(st.nextToken());
      int M = Integer.parseInt(st.nextToken());

      int[][] arr = new int[N][N];
      for(int i=0; i<N; i++){
        st = new StringTokenizer(br.readLine());
        for(int j=0; j<N; j++) {
          arr[i][j] = Integer.parseInt(st.nextToken());
        }
      }
      int max=0;
      for(int i=0; i<=N-M; i++){
        for(int j=0; j<=N-M; j++){
          int temp=0;
          for(int k=i; k<i+M; k++){
            for(int l=j; l<j+M; l++){
              temp+= arr[k][l];
            }
          }
          if(temp>max){
            max=temp;
          }
        }
      }
      sb.append(max).append("\n");
    }
    System.out.println(sb);
  }
}
