import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();
    while(T-->0){
      int N = Integer.parseInt(br.readLine());
      Map<String, Integer> map = new HashMap<>();
      while(N-->0){
        StringTokenizer st = new StringTokenizer(br.readLine());
        String a = st.nextToken();
        String b= st.nextToken();
        map.put(b,map.getOrDefault(b,0)+1);
      }

      int result = 1;
      for(int n : map.values()){
        result*=(n+1);
      }
      sb.append(result-1).append("\n");
    }
    System.out.println(sb);
  }
}
