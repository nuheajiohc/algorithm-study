import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[] arr = new int[N];

    StringTokenizer st = new StringTokenizer(br.readLine());

    for(int i=0; i<N; i++){
      arr[i] = Integer.parseInt(st.nextToken());
    }

    int[] vis = new int[100001];
    long count=0;
    int s=0;
    for(int i=0; i<N; i++){
      vis[arr[i]]++;
      while(vis[arr[i]]>1){
        vis[arr[s]]--;
        s++;
      }
      count+=i-s+1;
    }
    System.out.println(count);
  }
}
