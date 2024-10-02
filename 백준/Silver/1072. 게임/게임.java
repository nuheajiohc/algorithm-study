import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  private static long X,Y,Z;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    X = Integer.parseInt(st.nextToken());
    Y = Integer.parseInt(st.nextToken());
    Z = Y*100/X;

    long s = 0;
    long e = 2000000000;
    while(s+1<e){
      long mid = (s+e)/2;
      if(check(mid)) s=mid;
      else e=mid;
    }
    System.out.println(e==2000000000?-1:e);
  }

  public static boolean check(long target){
    long child= (Y+target) * 100L;
    long parent = X+target;
    return (child/parent)<=Z;
  }
}
