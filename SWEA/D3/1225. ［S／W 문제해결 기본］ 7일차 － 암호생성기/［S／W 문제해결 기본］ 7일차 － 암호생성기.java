import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringBuilder sb = new StringBuilder();
    for(int tc=1; tc<=10; tc++) {
      br.readLine();
      Queue<Integer> q = new ArrayDeque<>();
      StringTokenizer st = new StringTokenizer(br.readLine());
      while(st.hasMoreTokens()){
        q.offer(Integer.parseInt(st.nextToken()));
      }

      int count=1;
      while(!q.isEmpty()){
        int num = q.poll();
        num-=count;
        if(num<=0){
          q.offer(0);
          break;
        }else{
          q.offer(num);
        }
        count++;
        if(count==6){
          count=1;
        }
      }

      sb.append("#").append(tc).append(" ");
      while(!q.isEmpty()){
        sb.append(q.poll()).append(" ");
      }
      sb.append("\n");
    }

    System.out.println(sb);
  }
}
