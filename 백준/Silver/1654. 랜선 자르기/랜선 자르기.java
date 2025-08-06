import java.io.*;
import java.util.*;

public class Main {

    private static int K,N;
    private static int[] arr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new int[K];
        for(int i=0; i<K; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        long s=1;
        long e=(1L)<<31;
        while(s+1<e){
            long mid = (s+e)/2;
            if(check(mid)) s=mid;
            else e=mid;
        }
        System.out.println(s);
    }

    public static boolean check(long target){
        long count=0;
        for(int i=0; i<K; i++){
            count += arr[i]/target;
        }
        return count>=N;
    }
}
