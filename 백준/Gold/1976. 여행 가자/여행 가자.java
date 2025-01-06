import java.io.*;
import java.util.*;

public class Main {

  private static int[] parent;
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int M = Integer.parseInt(br.readLine());


    parent = new int[N+1];

    for(int i=1; i<=N; i++){
      parent[i]=i;
    }
    
    for(int i=1; i<=N; i++){
      StringTokenizer st = new StringTokenizer(br.readLine());
      for(int j=1; j<=N; j++){
        int connected = Integer.parseInt(st.nextToken());
        if(connected==1){
          union(i,j);
        }
      }
    }

    StringTokenizer st = new StringTokenizer(br.readLine());
    int[] city = new int[M];
    for(int i=0; i<M; i++){
      city[i] = Integer.parseInt(st.nextToken());
    }

    boolean isPossible = true;
    int root = find(city[0]);
    for(int i=1; i<M; i++){
      if(find(city[i]) != root){
        isPossible = false;
        break;
      }
    }
    System.out.println(isPossible?"YES":"NO");
  }

  private static int find(int x){
    if(parent[x] != x){
      parent[x] = find(parent[x]);
    }
    return parent[x];
  }

  private static void union(int a, int b){
    int rootA = find(a);
    int rootB = find(b);
    if(rootA!=rootB){
      parent[rootB] = rootA;
    }
  }
}
