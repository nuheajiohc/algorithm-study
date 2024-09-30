import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());

    StringBuilder sb = new StringBuilder();
    while(T-->0){
      int N = Integer.parseInt(br.readLine());
      int[][] rank = new int[N][2];
      for(int i = 0; i < N; i++){
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        rank[i] = new int[]{a,b};
      }
      Arrays.sort(rank, (a,b)->{
        if(a[0]==b[0]) return a[1]-b[1];
        return a[0]-b[0];
      });

      int count=1;
      int idx=rank[0][1];
      for(int i = 1; i < N; i++){
        if(idx>rank[i][1]){
          idx = rank[i][1];
          count++;
        }
      }
      sb.append(count).append("\n");
    }
    System.out.println(sb);
  }

}
