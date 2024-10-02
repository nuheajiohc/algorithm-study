import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int[][][] dp = new int[21][21][21];

    for(int i=0; i<=20; i++){
      for(int j=0; j<=20; j++){
        for(int k=0; k<=20; k++){
          if(i==0 || j==0 || k==0){
            dp[i][j][k] = 1;
            continue;
          }
          if(i<j && j<k) dp[i][j][k] = dp[i][j][k-1] + dp[i][j-1][k-1] - dp[i][j-1][k];
          else dp[i][j][k] = dp[i-1][j][k] + dp[i-1][j-1][k] + dp[i-1][j][k-1] - dp[i-1][j-1][k-1];
        }
      }
    }

    while(true){
      String line = br.readLine();
      StringTokenizer st = new StringTokenizer(line);
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());
      if(a==-1 && b==-1 && c==-1)break;
      sb.append("w(").append(a).append(", ").append(b).append(", ").append(c).append(") = ");
      if(a<1 || b<1 || c<1){
        sb.append(1);
      }else if(a>20 || b>20 || c>20){
        sb.append(dp[20][20][20]);
      }else{
        sb.append(dp[a][b][c]);
      }
      sb.append("\n");
    }
    System.out.println(sb);
  }
}
