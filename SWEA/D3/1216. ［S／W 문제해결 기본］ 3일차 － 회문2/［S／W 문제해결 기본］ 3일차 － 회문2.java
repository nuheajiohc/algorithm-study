import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringBuilder sb = new StringBuilder();
    for(int tc=1; tc<=10; tc++){
      int t = Integer.parseInt(br.readLine());
      char[][] arr = new char[100][100];
      for(int i=0; i<100; i++){
        arr[i] = br.readLine().toCharArray();
      }
      int max=1;
      for(int k=100; k>1; k--){
        if(exist(arr,k)){
          max = k;
          break;
        }
      }
      sb.append(String.format("#%d %d%n", t, max));
    }
    System.out.println(sb);
  }


  public static boolean exist(char[][] arr, int k){
    for(int i=0; i<100; i++){
      for(int j=0; j<100; j++){
        if(checkRight(arr, i, j, k) || checkDown(arr,i,j,k)){
          return true;
        }
      }
    }
    return false;
  }
  public static boolean checkRight(char[][] arr, int i, int j, int length){
    if(j+length>100) return false;
    for(int k=0; k<length/2; k++){
      if(arr[i][j+k]!=arr[i][j+length-k-1]) return false;
    }
    return true;

  }

  public static boolean checkDown(char[][] arr, int i, int j, int length){
    if(i+length>100) return false;
    for(int k=0; k<length/2; k++){
      if(arr[i+k][j]!=arr[i+length-k-1][j]) return false;
    }
    return true;
  }

}
