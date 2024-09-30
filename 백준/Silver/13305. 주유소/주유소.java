import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    long[] distance = new long[N-1];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N-1; i++) {
      distance[i] = Integer.parseInt(st.nextToken());
    }

    long[] position = new long[N];
    st = new StringTokenizer(br.readLine());
    for(int i=0; i<N; i++){
      position[i] = Integer.parseInt(st.nextToken());
    }

    long min=0;
    long cur_pos=Integer.MAX_VALUE;
    for(int i=0; i<N-1; i++){
      if(cur_pos > position[i]){
          min += position[i]*distance[i];
          cur_pos = position[i];
      }else{
        min += cur_pos*distance[i];
      }
    }
    System.out.println(min);
  }
}
