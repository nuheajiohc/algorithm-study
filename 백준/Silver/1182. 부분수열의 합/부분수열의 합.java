import java.util.*;
import java.io.*;

public class Main {

    private static int N,S;
    private static int[] nums;
    private static int count;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        backtracking(0,0);
        System.out.println(S==0?count-1:count);
    }

    public static void backtracking(int depth, int sum){
        if(depth==N){
            if(sum==S){
                count++;
            }
            return;
        } 
        backtracking(depth+1,sum);
        backtracking(depth+1,sum+nums[depth]);

    }
}
