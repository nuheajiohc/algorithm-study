import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    String[] word = new String[N];
    for(int i =0; i<N; i++){
      word[i] = br.readLine();
    }
    Arrays.sort(word,(a,b)->{
      if(a.length()==b.length()){
        return a.compareTo(b);
      }
      return a.length()-b.length();
    });

    StringBuilder sb = new StringBuilder();
    String curWord = word[0];
    sb.append(word[0]).append("\n");
    for(int i=1; i<N; i++){
      if(!curWord.equals(word[i])){
        curWord = word[i];
        sb.append(word[i]).append("\n");
      }
    }
    System.out.println(sb);
  }
}
