import java.io.*;
import java.util.*;

public class Solution {

    static int N, cnt;
    static int[] arr = new int[9];
    static boolean[] used = new boolean[9];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int tc=1; tc<=TC; tc++){
            N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            cnt = 0;
            recursion(0, 0 ,0);
            sb.append("#").append(tc).append(" ").append(cnt).append("\n");
        }
        System.out.println(sb);
    }
    
    static void recursion(int depth, int leftSum,  int rightSum){
        if(leftSum<rightSum) return;

        if(depth==N){
            cnt++;
            return;
        }

        for(int i=0; i<N; i++){
            if(used[i]) continue;
            used[i] = true;
            recursion(depth+1, leftSum+arr[i], rightSum);
            recursion(depth+1, leftSum, rightSum+arr[i]);
            used[i] = false;
        }
    }
}
