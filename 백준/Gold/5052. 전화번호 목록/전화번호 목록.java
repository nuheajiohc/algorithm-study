import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

  private static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());

    while (t-- > 0) {
      int n = Integer.parseInt(br.readLine());
      String[] phone = new String[n];
      for (int i = 0; i < n; i++) {
        String s = br.readLine();
        phone[i] = s;
      }
      Arrays.sort(phone);
      check(n, phone);

    }
    System.out.println(sb);
  }

  public static void check(int n, String[] phone) {
    for (int i = 0; i < n - 1; i++) {
      int minLength = Math.min(phone[i].length(), phone[i + 1].length());
      int count=0;
      for (int j = 0; j < minLength; j++) {
        if(phone[i].charAt(j) != phone[i + 1].charAt(j)) {
          break;
        }
        count++;
      }
      if(count == minLength){
        sb.append("NO").append("\n");
        return;
      }
    }
    sb.append("YES").append("\n");
  }
}
