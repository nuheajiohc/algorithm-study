import java.io.*;
import java.util.*;


public class Main {

    static long[] bit;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        initBitCount();
        
        long ans = getBitCount(B)- getBitCount(A-1);
        System.out.println(ans);
    }

    public static long getBitCount(long x){
        long ans = x&1;

        for(int i=54; i>0; i--){
            if((x&(1L<<i)) >0L) {
                ans += bit[i-1] + (x- (1L<<i) +1);
                x-= (1L <<i);
            }
        }
        return ans;
    }

    public static void initBitCount(){
        bit = new long[55];
        bit[0]=1;
        for(int i=1; i<55; i++){
            bit[i] = 2*bit[i-1] + (1L<<i);
        }
    }
}
