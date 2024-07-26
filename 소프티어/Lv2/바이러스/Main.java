import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        long result=K;
        while(N-->0){
            result*=P;
            result = result%1000000007;
        }
        System.out.println(result);
    }
}
