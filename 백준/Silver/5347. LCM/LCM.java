import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(N-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());            
            sb.append(a*b/gcd(a,b)).append("\n");
        }
        System.out.println(sb.toString());
    }

    public static long gcd(long x,long y){
        if(x%y==0) return y;
        return gcd(y,x%y);
    }
}
