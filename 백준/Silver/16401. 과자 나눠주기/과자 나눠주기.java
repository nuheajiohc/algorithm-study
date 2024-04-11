import java.util.*;
import java.io.*;

public class Main {

    private static int[] snack;
    private static int M,N;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        snack = new int [N];
        for(int i=0; i<N; i++){
            snack[i] = Integer.parseInt(st.nextToken());
        }

        int s=0;
        int e=1000000001;
        while(s+1<e){
            int mid = (s+e)/2;
            if(check(mid)) s=mid;
            else e =mid;
        }
        System.out.println(s);

    }

    public static boolean check(int length){
        int sum=0;
        for(int i=0; i<N; i++){
            if(snack[i]>=length){
                sum += snack[i]/length;
            }
        }
        return sum>=M;
    }
}
