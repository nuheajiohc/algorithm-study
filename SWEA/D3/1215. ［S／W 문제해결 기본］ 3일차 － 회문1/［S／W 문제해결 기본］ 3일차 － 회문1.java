import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringBuilder sb = new StringBuilder();
    for(int tc=1; tc<=10; tc++){
      int length = Integer.parseInt(br.readLine());
      char[][] arr = new char[8][8];
      for(int i=0; i<8; i++){
        arr[i] = br.readLine().toCharArray();
      }

      int count=0;
      for(int i=0; i<8; i++){
        for(int j=0; j<8; j++){
          if(rightCheck(arr,i,j,length)){
            count++;
          }
          if(downCheck(arr, i,j,length)){
            count++;
          }
        }
      }
      sb.append(String.format("#%d %d%n",tc, count));
    }
    System.out.println(sb);
  }

  public static boolean rightCheck(char[][] arr, int i, int j, int length){
    if(j+length>8) return false;
    for(int k=0; k<length/2; k++){
      if(arr[i][j+k]!=arr[i][j+length-k-1]) return false;
    }
    return true;
  }

  public static boolean downCheck(char[][] arr, int i, int j, int length){
    if(i+length>8) return false;
    for(int k=0; k<length/2; k++){
      if(arr[i+k][j]!=arr[i+length-k-1][j]) return false;
    }
    return true;
  }
}
