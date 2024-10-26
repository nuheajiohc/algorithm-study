import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Solution {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringBuilder sb = new StringBuilder();
    for(int tc=1; tc<=10; tc++){
      StringTokenizer st = new StringTokenizer(br.readLine());
      int length = Integer.parseInt(st.nextToken());
      String password = st.nextToken();
      Deque<Character> dq = new ArrayDeque<>();
      for(int i=0; i<length; i++){
        char n = password.charAt(i);
        if(dq.isEmpty()){
          dq.offer(n);
        } else{
          if(dq.peekLast() == n){
            dq.pollLast();
          }else{
            dq.offer(n);
          }
        }
      }
      sb.append("#").append(tc).append(" ");
      while(!dq.isEmpty()){
        sb.append(dq.poll());
      }
      sb.append("\n");
    }
    System.out.println(sb);
  }
}
