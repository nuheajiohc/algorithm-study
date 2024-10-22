import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int kbs1_idx=0;
    int kbs2_idx=0;
    for(int i = 0; i < N; i++) {
      String s = br.readLine();
      if(s.equals("KBS1")){
        kbs1_idx=i;
      }
      if(s.equals("KBS2")){
        kbs2_idx=i;
      }
    }

    if(kbs1_idx<kbs2_idx){
      System.out.println("1".repeat(kbs1_idx)+"4".repeat(kbs1_idx)+"1".repeat(kbs2_idx)+"4".repeat(kbs2_idx-1));
    }else{
      System.out.println("1".repeat(kbs1_idx)+"4".repeat(kbs1_idx)+"1".repeat(kbs2_idx+1)+"4".repeat(kbs2_idx));
    }
  }
}
