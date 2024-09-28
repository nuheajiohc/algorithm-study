import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  private static int N;
  private static int[][] ability;
  private static boolean[] vis;
  private static int minDiff = Integer.MAX_VALUE;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    ability = new int[N][N];
    for(int i=0; i<N; i++){
      StringTokenizer st = new StringTokenizer(br.readLine());
      for(int j=0; j<N; j++){
        ability[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    vis = new boolean[N];
    vis[0] = true;
    btk(1,1);
    System.out.println(minDiff);
  }

  public static void btk(int depth, int k){
    if(depth==N/2){
        minDiff = Math.min(minDiff, getMinDiff());
        return;
    }

    for(int i=k; i<N; i++){
      vis[i] = true;
      btk(depth+1, i+1);
      vis[i]= false;
    }
  }

  public static int getMinDiff(){
    int link = 0;
    int start =0;

    for(int i=0; i<N; i++){
      for(int j=0; j<N; j++){
        if(vis[i] && vis[j]) link+=ability[i][j];
        if(!vis[i] && !vis[j]) start+=ability[i][j];
      }
    }
    return Math.abs(link-start);
  }
}
