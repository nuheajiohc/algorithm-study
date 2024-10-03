import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  private static int n,m;
  private static int[] arr;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    arr= new int[n];
    st = new StringTokenizer(br.readLine());
    int s=0;
    int e=1000000000;
    for(int i=0;i<n;i++){
      arr[i] = Integer.parseInt(st.nextToken());
      s = Math.max(s, arr[i]);
    }
    s-=1;
    while(s+1<e){
      int mid = (s+e)/2;
      if(check(mid)) s=mid;
      else e=mid;
    }
    System.out.println(e);
  }

  private static boolean check(int target){
    int sum=0;
    int count=1;
    for(int i=0;i<n;i++) {
      sum += arr[i];
      if (sum > target) {
        count++;
        sum = arr[i];
      }
    }
    return count>m;
  }
}
