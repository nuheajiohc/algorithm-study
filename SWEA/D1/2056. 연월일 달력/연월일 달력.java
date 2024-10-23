import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    for (int i = 1; i <= T; i++) {
      String line = br.readLine();

      String year = line.substring(0, 4);
      String month = line.substring(4, 6);
      String day = line.substring(6, 8);

      String answer = "-1";
      if (isPossibleCalender(year, month, day)) {
        answer = String.format("%s/%s/%s", year, month, day);
      }
      System.out.printf("#%d %s%n", i, answer);
    }
  }

  public static boolean isPossibleCalender(String y, String m, String d) {
    int year = Integer.parseInt(y);
    int month = Integer.parseInt(m);
    int day = Integer.parseInt(d);
    if (year == 0 || month == 0 || day == 0) {
      return false;
    }
    if (month > 12) {
      return false;
    }
    if (month == 2 && day > 28) {
      return false;
    }
    if (month % 2 == 0 && day <= 30) {
      return true;
    }
    if (month % 2 == 1 && day <= 31) {
      return true;
    }
    return false;
  }
}
