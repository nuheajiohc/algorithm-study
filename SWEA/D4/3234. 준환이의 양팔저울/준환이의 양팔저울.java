import java.io.*;
import java.util.*;

public class Solution {

    static int N;
    static int[] arr = new int[9];
    static boolean[] used = new boolean[9];

    static int[] fact = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};
    static int[] pow = {1, 2, 4, 8, 16, 32, 64, 128, 256, 512};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int tc=1; tc<=TC; tc++){
            N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int totalWeight = 0;
            for(int i=0; i<N; i++){
                arr[i] = Integer.parseInt(st.nextToken());
                totalWeight += arr[i];
            }
            int cnt = recursion(0, 0 ,0, totalWeight);
            sb.append("#").append(tc).append(" ").append(cnt).append("\n");
        }
        System.out.println(sb);
    }
    
    static int recursion(int depth, int leftSum,  int rightSum, int remain){
        if(leftSum<rightSum) return 0;

        if(leftSum>=rightSum+remain){
            return fact[N-depth] * pow[N-depth];
        }

        if(depth==N){
            return 1;
        }

        int cnt = 0;
        for(int i=0; i<N; i++){
            if(used[i]) continue;
            used[i] = true;
            cnt += recursion(depth+1, leftSum+arr[i], rightSum, remain-arr[i]);
            cnt += recursion(depth+1, leftSum, rightSum+arr[i], remain-arr[i]);
            used[i] = false;
        }
        return cnt;
    }
}
