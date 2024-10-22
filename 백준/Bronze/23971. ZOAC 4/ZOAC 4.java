import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int a = H/(N+1);
        if(H%(N+1)>0){
            a+=1;
        }

        int b = W/(M+1);
        if(W%(M+1)>0){
            b+=1;
        }
        System.out.println(a*b);
    }
}
