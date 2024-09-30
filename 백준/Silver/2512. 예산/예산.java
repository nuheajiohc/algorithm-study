import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  private static int N,M;
  private static int[] arr;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    arr = new int[N];

    StringTokenizer st = new StringTokenizer(br.readLine());
    int max =0;
    for(int i=0; i<N; i++){
      arr[i] = Integer.parseInt(st.nextToken());
      max = Math.max(max, arr[i]);
    }
    M = Integer.parseInt(br.readLine());

    int s = 1;
    int e = max+1;
    while(s+1<e){
      int mid = (s+e)/2;
      if(check(mid)) s=mid;
      else e=mid;
    }
    System.out.println(s);
  }

  public static boolean check(int target){
    int budget=0;
    for(int i=0; i<N; i++){
      if(arr[i]>target){
        budget+=target;
      }else{
        budget+=arr[i];
      }
    }
    return M>=budget;
  }

}
