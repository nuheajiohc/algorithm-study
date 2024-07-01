import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[] nums = new boolean[N+1];
        Arrays.fill(nums,true);
        
        for(int i=2; i<=N; i++){
            if(!nums[i]) continue;
            for(int j=i+i; j<=N; j+=i){
                nums[j]=false;
            }
        }
        List<Integer> primes = new ArrayList<>();
        for(int i=2; i<=N; i++){
            if(nums[i]) primes.add(i);
        }
        int s=0;
        long sum=0;
        int count=0;
        for(int e=0; e<primes.size(); e++){
            sum+=primes.get(e);
            while(s<e && sum>N){
                sum-=primes.get(s);
                s++;
            }
            if(sum==N){
                count++;
            }
        }
        System.out.println(count);
    }
}
