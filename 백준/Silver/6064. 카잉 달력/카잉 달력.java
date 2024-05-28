import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while(T-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int lcm = M*N/recursion(M,N);

            int count=x;
            while(count<=lcm){
                if(count%M==x%M && count%N==y%N){
                    break;
                }
                count+=M;
            }
            if(count<=lcm) sb.append(count).append("\n");
            else sb.append(-1).append("\n");
        }
        System.out.println(sb.toString());
    }

    public static int recursion(int M, int N){
        if(M%N==0) return N;
        return recursion(N, M%N);
    }
}
