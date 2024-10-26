import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] order = {"ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN"};
    Map<String, Integer> map = new HashMap<>();
    for(int i=0; i<10 ;i++){
      map.put(order[i], i);
    }

    StringBuilder sb = new StringBuilder();
    int t = Integer.parseInt(br.readLine());
    for(int tc=1; tc<=t; tc++){
      StringTokenizer st = new StringTokenizer(br.readLine());
      String th = st.nextToken();
      int length = Integer.parseInt(st.nextToken());
      Num[] nums = new Num[length];
      st = new StringTokenizer(br.readLine());
      for(int i=0; i<length ; i++){
        String alpha = st.nextToken();
        nums[i] = new Num(map.get(alpha), alpha);
      }

      Arrays.sort(nums);
      sb.append(th).append("\n");
      for(int i=0; i<length ; i++){
        sb.append(nums[i].alpha).append(" ");
      }
      sb.append("\n");
    }
    System.out.println(sb);
  }

  public static class Num implements Comparable<Num>{

    int idx;
    String alpha;

    Num(int idx, String alpha){
      this.idx = idx;
      this.alpha = alpha;
    }

    @Override
    public int compareTo(Num o){
      return idx-o.idx;
    }
  }
}
