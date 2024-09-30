import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  private static int[] arr;
  private static int[] selected;
  private static int N;
  private static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String line = "";
    while (!(line = br.readLine()).equals("0")) {
      StringTokenizer st = new StringTokenizer(line);
      N = Integer.parseInt(st.nextToken());
      arr = new int[N];
      selected = new int[6];
      for (int i = 0; i < N; i++) {
        arr[i] = Integer.parseInt(st.nextToken());
      }

      btk(0, 0);
      sb.append("\n");
    }
    System.out.println(sb);
  }

  public static void btk(int depth, int k) {
    if (depth == 6) {
      for(int num : selected) {
        sb.append(num).append(" ");
      }
      sb.append("\n");
      return;
    }

    for(int i=k; i<N; i++){
      selected[depth] = arr[i];
      btk(depth+1, i+1);
    }
  }
}
