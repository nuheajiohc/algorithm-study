import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int a = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    int[][] adj = new int[n + 1][n + 1];
    for (int i = 1; i <= n; i++) {
      Arrays.fill(adj[i], 1000);
      adj[i][i]=0;
    }

    while(m-->0){
      st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());
      adj[u][v]=1;
      adj[v][u]=1;
    }

    for(int k=1; k<=n; k++){
      for(int i=1; i<=n; i++){
        for(int j=1; j<=n; j++){
          if(adj[i][j]==0) continue;
          if(adj[i][j]>adj[i][k]+adj[k][j]){
            adj[i][j]=adj[i][k]+adj[k][j];
          }
        }
      }
    }

    if(adj[a][b]==1000){
      System.out.println(-1);
    }else{
      System.out.println(adj[a][b]);
    }
  }
}
