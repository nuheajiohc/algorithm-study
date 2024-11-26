import java.io.*;
import java.util.*;

public class Main {

  private static char[] start;
  private static char[] end;
  private static int N;
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());

    start = br.readLine().toCharArray();
    end = br.readLine().toCharArray();

    int result = 100001;

    char[] check = new char[N];
    for(int i=0; i<N; i++){
      check[i] = start[i];
    }

    int temp = calMin(check, 0);
    if(temp!=-1){
      result = temp;
    }

    check = new char[N];
    for(int i=0; i<N; i++){
      check[i] = start[i];
    }
    check[0] = (char)((check[0]+1-'0')%2+'0');
    check[1] = (char)((check[1]+1-'0')%2+'0');
    temp = calMin(check,1);
    if(temp!=-1){
      result = Math.min(result, temp);
    }
    
    System.out.println(result==100001?-1: result);
  }

  public static int calMin(char[] check, int count){
    for(int i=1; i<N-1; i++){
      if(check[i-1]==end[i-1]) continue;
      for(int j=i-1; j<=i+1; j++){
        check[j] = (char)((check[j]-'0'+1)%2+'0');
      }
      count++;
    }

    if(check[N-2]==end[N-2]){
      if(check[N-1]==end[N-1]) return count;
      else{
        return -1;
      }
    }else{
      if(check[N-1]!=end[N-1]) return count+1;
      else return -1;
    }
  }
}
