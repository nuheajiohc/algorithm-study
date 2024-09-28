import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[] arr = new int[N];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    int[] compress = getCompress(arr);
    StringBuilder sb= new StringBuilder();
    for(int i : compress){
      sb.append(i).append(" ");
    }
    System.out.println(sb);
  }

  private static int[] getCompress(int[] arr) {
    int[] newArr = arr.clone();
    Arrays.sort(newArr);

    Map<Integer,Integer> map = new HashMap<>();
    int rank=0;
    for (int j : newArr) {
      if (map.containsKey(j)) continue;
      map.put(j, rank++);
    }

    int[] compress = new int[newArr.length];
    for(int i=0; i<newArr.length; i++) {
      compress[i] = map.get(arr[i]);
    }
    return compress;
  }
}
