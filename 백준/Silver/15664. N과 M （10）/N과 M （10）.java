import java.io.*;
import java.util.*;

public class Main {

    private static int[] nums,vis;
    private static int N,M;
    private static StringBuilder sb = new StringBuilder();
    private static HashSet<String> set = new HashSet<>();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        nums = new int[N];
        vis = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);
        backtracking(0,0);
        System.out.println(sb.toString());
    }

    public static void backtracking(int k, int depth){
        if(depth==M){
            StringBuilder ss = new StringBuilder();
            for(int n : vis){
                ss.append(n).append(" ");
            }
            if(!set.contains(ss.toString())){
                sb.append(ss.toString()).append("\n");
                set.add(ss.toString());
            }
            return;
        }

        for(int i=k; i<N;i++){
            vis[depth] = nums[i];
            backtracking(i+1,depth+1);
        }
    }
}
