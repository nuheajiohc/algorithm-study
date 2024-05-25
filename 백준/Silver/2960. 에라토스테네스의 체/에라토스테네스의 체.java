import java.io.*;
import java.util.*;

public class Main {

    private static int N,K;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        System.out.println(sieve());
    }

    public static int sieve(){
        int[] nums = new int[N+1];
        int count=0;
        for(int i=2; i<=N; i++){
            for(int j=i; j<=N; j+=i){
                if(nums[j]!=0) continue;
                nums[j]=j;
                count++;
                if(count==K){
                    return j;
                }
            }
        }
        return 0;
    }
}
