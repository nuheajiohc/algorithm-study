import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        boolean[] isPrime = new boolean[1000001];
        Arrays.fill(isPrime, true);
        for(int i=2; i<=1000000; i++){
            if(!isPrime[i]) continue;
            for(int j=i+i; j<=1000000; j+=i){
                isPrime[j] = false;
            }
        }

        StringBuilder sb = new StringBuilder();
        while(T-->0){
            int N = Integer.parseInt(br.readLine());
            int count=0;
            for(int i=2; i<=N/2; i++){
                if(isPrime[i] && isPrime[N-i]){
                    count++;
                }
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb.toString());
    }
}
