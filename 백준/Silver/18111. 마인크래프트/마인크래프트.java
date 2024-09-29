import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int B = Integer.parseInt(st.nextToken());

    Integer[] block = new Integer[N*M];
    int count=0;
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        block[count] = Integer.parseInt(st.nextToken());
        count++;
      }
    }


    Arrays.sort(block, (a,b)->b-a);
    int height =0;
    int time= Integer.MAX_VALUE;
    int max = block[0];
    int min = block[block.length-1];
    for(int i=max; i>=min; i--){
      int temp = B;
      int temp_time=0;
      boolean imPossible= false;
      for(int j=0; j<block.length; j++){
        if(block[j]>=i){
          temp+=block[j]-i;
          temp_time+=2*(block[j]-i);
        }else{
          if(temp>=(i-block[j])){
            temp-=i-block[j];
            temp_time+=(i-block[j]);
          }else{
            imPossible=true;
            break;
          }
        }
      }
      if(imPossible) continue;
      if(temp_time< time){
        time = temp_time;
        height = i;
      }
    }
    System.out.println(time + " " + height);
  }
}
