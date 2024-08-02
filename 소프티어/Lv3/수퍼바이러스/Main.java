import java.io.*;
import java.util.*;

public class Main {

    private static final long MOD =1_000_000_007;
    private static long K,P,N;
    private static Map<Long,Long> map = new HashMap<>();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Long.parseLong(st.nextToken());
        P = Long.parseLong(st.nextToken());
        N = Long.parseLong(st.nextToken());
        
        System.out.println(check(N*10)*K % MOD);
    }

    public static long check(long n){
        if(n==1) return P;
        if(map.containsKey(n)) return map.get(n);
        long temp;
        if(n%2==0){
            temp = (check(n/2) * check(n/2))%MOD;
        }else{
            temp = (check(n/2) * check((n+1)/2)) % MOD;
        }
        map.put(n,temp);   
        return temp;
    }
}
