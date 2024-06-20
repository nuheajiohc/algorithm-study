import java.io.*;
import java.util.*;

public class Main {

    private static long N,P,Q;
    private static Map<String,String> A = new HashMap<>();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Long.parseLong(st.nextToken());
        P = Long.parseLong(st.nextToken());
        Q = Long.parseLong(st.nextToken());
        A.put("0","1");
        System.out.println(recur(N));
        
    }

    public static long recur(long n){
        if(A.containsKey(String.valueOf(n))){
            return Long.parseLong(A.get(String.valueOf(n)));
        }

        long sum = recur(n/P)+recur(n/Q);
        A.put(String.valueOf(n),String.valueOf(sum));
        return sum;
    }

}
