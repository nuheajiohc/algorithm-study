import java.io.*;
import java.util.*;

public class Main {

    private static int N;
    private static int[][] foods;
    private static long minDiff=Long.MAX_VALUE;

    public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    foods = new int[N][2];
    for(int i=0; i<N; i++){
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        foods[i] = new int[]{a,b};
    }
    findMinDiff(0,1,0);
    System.out.println(minDiff);
    }

    public static void findMinDiff(int i, long a, long b){
        if(i==N){
            long diff = Math.abs(a-b);
            if(b!=0) minDiff = Math.min(diff,minDiff);
            return;
        }
        findMinDiff(i+1,a*foods[i][0],b+foods[i][1]);
        findMinDiff(i+1,a,b);
    }
}
