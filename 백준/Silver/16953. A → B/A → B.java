import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  private static int A,B;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    A= Integer.parseInt(st.nextToken());
    B= Integer.parseInt(st.nextToken());

    int min = dfs(B,1);
    System.out.println(min);
  }

  private static int dfs(int cur, int count){
    if(cur<A) return -1;
    if(A==cur){
      return count;
    }

    if(cur%2==0){
      return dfs(cur/2, count+1);
    }else if(cur%10==1){
      return dfs((cur-1)/10, count+1);
    }else{
      return -1;
    }
  }
}
