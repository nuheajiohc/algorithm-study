import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    StringBuilder sb = new StringBuilder();
    for(int i=1; i<=N; i++){
      int temp = i;
      int count=0;
      while(temp>0){
        int r = temp%10;
        temp = temp/10;
        if(r!=0 && r%3==0){
          count++;
        }
      }
      if(count==0){
        sb.append(i);
      }else{
        for(int j=0; j<count; j++){
          sb.append("-");
        }
      }
      sb.append(" ");
    }
    System.out.println(sb);
  }
}
