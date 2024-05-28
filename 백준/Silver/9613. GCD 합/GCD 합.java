import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while(T-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int[] nums = new int[N];
            for(int i=0; i<N; i++){
                nums[i] = Integer.parseInt(st.nextToken());
            }

            long sum=0;
            for(int i=0; i<N-1; i++){
                for(int j=i+1; j<N; j++){
                    sum += gcd(nums[i],nums[j]);
                }
            }
            sb.append(sum).append("\n");
        }
        System.out.println(sb.toString());
    }

    public static int gcd(int x, int y){
        if(x%y==0) return y;
        return gcd(y,x%y);
    }
}
