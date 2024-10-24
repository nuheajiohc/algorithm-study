import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());

    StringBuilder sb = new StringBuilder();
    for(int testcase=1; testcase<=T; testcase++){
      int N = Integer.parseInt(br.readLine());
      int[][] arr = new int[N][N];
      fill(arr);

      sb.append("#").append(testcase).append("\n");
      for(int i=0; i<N; i++){
        for(int j=0; j<N; j++){
          sb.append(arr[i][j]).append(" ");
        }
        sb.append("\n");
      }
    }
    System.out.println(sb);
  }

  private static void fill(int[][] arr){
    int minLimitX=0;
    int maxLimitX=arr.length-1;
    int minLimitY=0;
    int maxLimitY=arr.length-1;
    int cur_x=0;
    int cur_y=0;
    for(int i=1; i<=arr.length*arr.length; i++){
      arr[cur_x][cur_y]=i;
      if(cur_x==minLimitX && cur_y < maxLimitY){
        cur_y++;
      }else if(cur_x<maxLimitX && cur_y == maxLimitY){
        cur_x++;
      }else if(cur_x==maxLimitX && cur_y > minLimitY){
        cur_y--;
      }else{
        if(cur_x==minLimitX+1 && cur_y == minLimitY){
          minLimitX++;
          maxLimitX--;
          minLimitY++;
          maxLimitY--;
          cur_y++;
          continue;
        }
        cur_x--;
      }
    }
  }
}
