import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line = br.readLine();
    StringBuilder sb = new StringBuilder();
    for(int i=0; i<line.length(); i++) {
      sb.append(line.charAt(i)-'A'+1).append(" ");
    }
    System.out.println(sb);
  }
}
