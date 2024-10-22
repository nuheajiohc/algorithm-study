import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    int count=0;
    int cur=1;
    while(cur<N){
      count++;
      cur+=6*count;
    }
    System.out.println(count+1);
  }
}
