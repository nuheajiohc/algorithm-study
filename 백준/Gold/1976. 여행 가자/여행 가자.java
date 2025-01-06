import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int M = Integer.parseInt(br.readLine());
    int[][] conn = new int[N+1][N+1];
    for(int i=1; i<=N; i++){
      StringTokenizer st = new StringTokenizer(br.readLine());
      for(int j=1; j<=N; j++){
        conn[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    for(int i=1; i<=N; i++){
      conn[i][i]=1;
    }

    for(int i=1; i<=N; i++){
      for(int j=1; j<=N; j++){
        for(int k=1; k<=N; k++){
          if(conn[j][i]==1 && conn[i][k]==1){
            conn[j][k]=1;
          }
        }
      }
    }

    StringTokenizer st = new StringTokenizer(br.readLine());
    int[] city = new int[M];
    for(int i=0; i<M; i++){
      city[i] = Integer.parseInt(st.nextToken());
    }


    boolean isPossible= true;
    for(int i=1; i<M; i++){
      if(conn[city[i-1]][city[i]]!=1){
        isPossible = false;
        break;
      }
    }
    if(isPossible){
      System.out.println("YES");
    }else{
      System.out.println("NO");
    }
  }
}
