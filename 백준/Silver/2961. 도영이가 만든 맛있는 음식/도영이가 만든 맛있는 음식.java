import java.io.*;
import java.util.*;

public class Main {

    private static int N;
    private static int[][] arr;
    private static long ans = Long.MAX_VALUE;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][2];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        backtracking(0,0,1,0);
        System.out.println(ans);
    }

    public static void backtracking(int k, int depth,int a, int b){
        for(int i=k; i<N; i++){
            a*=arr[i][0];
            b+=arr[i][1];
            ans = Math.min(ans,Math.abs(a-b));
            backtracking(i+1,depth+1,a,b);
            a/=arr[i][0];
            b-=arr[i][1];
        }
    }
}
