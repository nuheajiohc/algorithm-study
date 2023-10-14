import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int N, M;
    private static boolean[] isUsed;
    private static int[] nums;
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        nums = new int[M];
        isUsed = new boolean[N];

        permutations(0);
        System.out.println(sb);
    }

    public static void permutations(int k) {
        if (k == M) {
            for (int num : nums) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!isUsed[i]) {
                nums[k] = i+1;
                isUsed[i] = true;
                permutations(k + 1);
                isUsed[i] = false;
            }
        }
    }
}
