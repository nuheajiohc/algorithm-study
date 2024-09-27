import java.io.*;
import java.util.*;

public class Main {

    private static int N,M;
    private static int[] arr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int s = 0;
        int e = 1000000001;
        while(s+1<e){
            int mid = (s+e)/2;
            if(check(mid)) s = mid;
            else e = mid;
        }

       System.out.println(s);
    }

    public static boolean check(int target){
        long tree =0;
        for(int i=0; i<N; i++){
            if(target<arr[i]){
                tree += arr[i]-target;   
            }
        }
        return M<=tree;
    }
}
