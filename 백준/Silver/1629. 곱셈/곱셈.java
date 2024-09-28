import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    long A = Integer.parseInt(st.nextToken());
    long B = Integer.parseInt(st.nextToken());
    long C = Integer.parseInt(st.nextToken());

    long result = recur(A,B,C);
    System.out.println(result);
  }


  public static long recur(long A, long B, long C) {
    if(B==1){
      return A%C;
    }

    long temp = recur(A,B/2, C);
    if(B%2 ==1){
      return (temp*temp%C)*A%C;
    }

    return (temp*temp)%C;
  }
}
