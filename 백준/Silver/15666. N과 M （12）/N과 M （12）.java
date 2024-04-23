import java.io.*;
import java.util.*;

public class Main {

    private static int N,M;
    private static int[] nums,res;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        nums = new int[N];
        for(int i=0; i<N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);

        res = new int[M];
        backtracking(0,0);
        System.out.println(sb.toString());
    }

    public static void backtracking(int k, int depth){
        if(depth==M){
            for(int n : res){
                sb.append(n).append(" ");
            }
            sb.append("\n");
            return;
        }

        int temp=0;
        for(int i=k; i<N; i++){
            if(temp==nums[i]) continue;
            temp=nums[i];
            res[depth]=nums[i];
            backtracking(i,depth+1);
        }
    }
}
