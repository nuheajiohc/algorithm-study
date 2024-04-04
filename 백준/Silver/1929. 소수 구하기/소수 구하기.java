import java.io.*;
import java.util.*;

public class Main {

    private static int M,N;
    private static boolean[] nums;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        nums = new boolean[N+1];
        nums[1]=true;
        primeNumber(N);
        for(int i=M; i<=N; i++){
            if(!nums[i]){
                sb.append(i).append("\n");
            }
        }
        System.out.println(sb.toString());
    }

    public static void primeNumber(int n){
        for(int i=2; i<=N; i++){
            if(nums[i]) continue;
            for(int j=i+i; j<=N; j+=i){
                nums[j] = true;
            }
        }
    }
}
