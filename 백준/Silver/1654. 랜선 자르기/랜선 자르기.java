import java.io.*;
import java.util.*;

public class Main {
    private static int[] line;
    private static int K,N;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stnr = new StringTokenizer(br.readLine());
        K = Integer.parseInt(stnr.nextToken());
        N = Integer.parseInt(stnr.nextToken());
        line = new int[K];
        for(int i=0; i<K; i++){
            line[i] = Integer.parseInt(br.readLine());
        }
        
        long st = 1;
        long en=(long)1e10 +7;
        while(st+1<en){
            long mid = (st+en)/2;
            if(isOverN(mid)) st = mid;
            else en = mid;
        }
        System.out.println(st);

    }   
    
    public static boolean isOverN(long x){
        long sum=0;
        for(int i=0; i<K; i++){
            sum+= line[i]/x;
        }
        return sum>=N;
    };
}
