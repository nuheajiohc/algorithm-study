import java.io.*;
import java.util.*;

public class Main {

  private static int N;
  private static int[] arr;
  private static int[] dp;
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    arr = new int[N];
    for(int i=0; i<N; i++){
      arr[i] = Integer.parseInt(br.readLine());
    }

    dp = new int[N];
    Arrays.fill(dp, 1);
    int max=0;
    for(int i=1; i<N; i++){
      for(int j=0; j<=i; j++){
        if(arr[i]>arr[j]){
          dp[i] = Math.max(dp[i],dp[j]+1);
        }
      }
      max = Math.max(max, dp[i]);
    }
    System.out.println(N-max);
  } 
}
