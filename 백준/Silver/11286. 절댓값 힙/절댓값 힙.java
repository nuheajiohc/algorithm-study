import com.sun.jdi.Value;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    StringBuilder sb = new StringBuilder();
    Queue<Value> pq = new PriorityQueue<>();
    while(N-->0){
      int x = Integer.parseInt(br.readLine());
      if(x==0){
        if(pq.isEmpty()){
          sb.append(0).append("\n");
        }else {
          sb.append(pq.poll().realValue).append("\n");
        }
      }else{
        pq.offer(new Value(x));
      }
    }
    System.out.println(sb);
  }

  public static class Value implements Comparable<Value>{
    int realValue;
    int absValue;

    public Value(int value) {
      this.realValue = value;
      this.absValue = Math.abs(value);
    }

    @Override
    public int compareTo(Value v){
      if(this.absValue == v.absValue){
        return this.realValue-v.realValue;
      }
      return this.absValue-v.absValue;
    }
  }
}
