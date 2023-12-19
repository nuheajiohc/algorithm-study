import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static int M;
    private static int[] nums;
    private static boolean[] vis;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        nums = new int[M];
        vis = new boolean[N+1];
        dfs(0);
        System.out.println(sb.toString());
    }

    public static void dfs(int depth){
        if(depth==M){
            for(int i=0; i<depth;i++){
                sb.append(nums[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=1; i<=N;i++){
            if(!vis[i]){
                vis[i]=true;
                nums[depth]=i;
                dfs(depth+1);
                vis[i]=false;
            }
        }
    }
}
