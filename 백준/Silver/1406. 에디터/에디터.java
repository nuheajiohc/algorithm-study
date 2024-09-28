import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    Deque<String> deque1 = new ArrayDeque<>();
    Deque<String> deque2 = new ArrayDeque<>();

    String str = br.readLine();
    for(int i = 0; i < str.length(); i++){
      deque1.offer(String.valueOf(str.charAt(i)));
    }

    int M = Integer.parseInt(br.readLine());
    while(M-->0){
      String line = br.readLine();
      StringTokenizer st = new StringTokenizer(line);
      String command = st.nextToken();
      if(command.equals("P")){
        String alpha = st.nextToken();
        deque1.offerLast(alpha);
      }else{
        if(command.equals("L")){
          if(deque1.isEmpty()) continue;
          String temp = deque1.pollLast();
          deque2.offerFirst(temp);
        }else if(command.equals("D")){
          if(deque2.isEmpty()) continue;
          String temp = deque2.pollFirst();
          deque1.offerLast(temp);
        }else{
          if(deque1.isEmpty()) continue;
          deque1.pollLast();
        }
      }
    }

    StringBuilder sb = new StringBuilder();
    while(!deque1.isEmpty()){
      sb.append(deque1.pollFirst());
    }
    while(!deque2.isEmpty()){
      sb.append(deque2.pollFirst());
    }
    System.out.println(sb);
  }
}
