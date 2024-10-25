import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringBuilder sb = new StringBuilder();
    for(int tc = 1; tc<=10; tc++){
      int n= Integer.parseInt(br.readLine());
      String target = br.readLine();
      String sentence = br.readLine();
      int size = sentence.split(target).length-1;
      if(sentence.startsWith(target)){
        size++;
      }
      if(sentence.endsWith(target)){
        size++;
      }
      sb.append(String.format("#%d %d%n", n, size));
    }
    System.out.println(sb);
  }
}
