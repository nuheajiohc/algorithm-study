import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int gcd = getGcd(b,d);
        int son = a*d/gcd + b*c/gcd;
        int mom = b*d/gcd;
        gcd = getGcd(son,mom);
        System.out.println(son/gcd+" "+mom/gcd);
    }

    public static int getGcd(int b, int d){
        if(d==0) return b;
        return getGcd(d,b%d);
    }
}
