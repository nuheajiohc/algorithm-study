import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int standardRadius = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();

        while(st.hasMoreTokens()){
            int cur = Integer.parseInt(st.nextToken());
            int gcdNum = gcd(standardRadius, cur);
            sb.append(standardRadius/gcdNum).append("/").append(cur/gcdNum).append("\n");
        }
        System.out.println(sb.toString());
    }

    public static int gcd(int x, int y){
        if(y==0) return x;
        return gcd(y,x%y);
    }
}
