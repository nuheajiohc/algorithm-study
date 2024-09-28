import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  private static int N;
  private static int[] A;
  private static int minVal = Integer.MAX_VALUE;
  private static int maxVal = Integer.MIN_VALUE;

  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    A = new int[N];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for(int i=0; i<N; i++){
      A[i] = Integer.parseInt(st.nextToken());
    }
    st = new StringTokenizer(br.readLine());
    int plus = Integer.parseInt(st.nextToken());
    int minus = Integer.parseInt(st.nextToken());
    int multi = Integer.parseInt(st.nextToken());
    int div = Integer.parseInt(st.nextToken());
    btk(plus,minus,multi,div,1, A[0]);
    System.out.println(maxVal);
    System.out.println(minVal);
  }

  private static void btk(int plus, int minus, int multi, int div, int depth, int result){
    if(plus==0 && minus==0 && multi==0 && div==0){
      maxVal = Math.max(maxVal,result);
      minVal = Math.min(minVal,result);
      return;
    }

    if(plus>0) btk(plus-1, minus, multi, div, depth+1, result+A[depth]);
    if(minus>0) btk(plus,minus-1, multi, div, depth+1, result-A[depth]);
    if(multi>0) btk(plus,minus,multi-1, div, depth+1, result*A[depth]);
    if(div>0) btk(plus,minus,multi,div-1, depth+1, result/A[depth]);
  }
}
