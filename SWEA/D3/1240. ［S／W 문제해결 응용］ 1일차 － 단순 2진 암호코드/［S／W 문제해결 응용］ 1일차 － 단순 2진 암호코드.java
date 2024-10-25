import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution {

  private static Map<String, Integer> code = new HashMap<>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    code.put("0001101", 0);
    code.put("0011001", 1);
    code.put("0010011", 2);
    code.put("0111101", 3);
    code.put("0100011", 4);
    code.put("0110001", 5);
    code.put("0101111", 6);
    code.put("0111011", 7);
    code.put("0110111", 8);
    code.put("0001011", 9);

    StringBuilder sb = new StringBuilder();
    int t = Integer.parseInt(br.readLine());
    for (int tc = 1; tc <= t; tc++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
      int m = Integer.parseInt(st.nextToken());
      String[] arr = new String[n];
      for (int i = 0; i < n; i++) {
        arr[i] = br.readLine();
      }

      int[] nums = new int[8];
      check(arr, nums, n, m);
      int result=0;
      for(int i=0; i<8; i++) {
        if(i%2==0){
          result+=nums[i];
        }else{
          result+=nums[i]*3;
        }
      }
      sb.append("#").append(tc).append(" ");
      if(result%10==0){
        int sum=0;
        for(int i=0; i<8; i++){
          sum+=nums[i];
        }
        sb.append(sum).append("\n");
      }else{
        sb.append("0").append("\n");
      }
    }
    System.out.println(sb);
  }

  public static void check(String[] arr, int[] nums, int n, int m) {
    for (int i = 0; i < n; i++) {
      for(int j=m-1; j>=7; j--){
        if(arr[i].charAt(j)=='1'){
          for(int k=0; k<8; k++){
            nums[k] = code.get(arr[i].substring(j+1-(k+1)*7, j+1-k*7));
          }
          return;
        }
      }
    }
  }
}
