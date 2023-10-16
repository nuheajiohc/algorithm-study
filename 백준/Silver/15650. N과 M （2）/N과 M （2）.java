import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int N, M;
    public static int[] nums;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        nums = new int[M];
        permutations(0,1);
        System.out.println(sb);
    }

    public static void permutations(int depth,int k){
        if(depth == M){
            for(int num : nums){
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=k; i<=N;i++){
            nums[depth] = i;
            permutations(depth+1,i+1);
        }
    }
}
