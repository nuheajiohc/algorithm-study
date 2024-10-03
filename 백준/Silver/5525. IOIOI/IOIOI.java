import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int M = Integer.parseInt(br.readLine());
    String S = br.readLine();

    int idx = 1;
    int answer=0;
    int count=0;
    while(idx<M-1){
      if(S.charAt(idx-1)=='I' && S.charAt(idx)=='O' && S.charAt(idx+1)=='I'){
        count++;
        if(count==N){
          answer++;
          count--;
        }
        idx+=2;
      }else{
        count=0;
        idx++;
      }
    }
    System.out.println(answer);
  }
}
