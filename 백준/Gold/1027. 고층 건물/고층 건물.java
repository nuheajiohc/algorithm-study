import java.io.*;
import java.util.*;

public class Main {

  private static int N;
  private static int[] building;

  public static void main(String[] args) throws Exception{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      N = Integer.parseInt(br.readLine());
      StringTokenizer st = new StringTokenizer(br.readLine());
      building = new int[N];
      for(int i=0; i<N; i++){
        building[i] = Integer.parseInt(st.nextToken());
      }

      int count=0;
      for(int i=0; i<N; i++){
        int temp=0;
        temp+=checkLeft(i);
        temp+=checkRight(i);
        count = Math.max(count, temp);
      }

      System.out.println(count);
  }

  private static int checkLeft(int pos){
    if(pos==0) return 0;
    double lean=(double)(building[pos]-building[pos-1]);
    int count=1;
    for(int i=pos-1; i>=0; i--){
      double temp = (building[pos]-building[i])/(double)(pos-i);
      if(lean>temp){
        count++;
        lean = temp;
      }
    }
    return count;
  }
  
  private static int checkRight(int pos){
    if(pos==N-1) return 0;
    double lean=(double)(building[pos+1]-building[pos]);
    int count=1;
    for(int i=pos+2; i<N; i++){
      double temp = (building[i]-building[pos])/(double)(i-pos);
      if(lean<temp){
        count++;
        lean = temp;
      }
    }
    return count;
  }
}
