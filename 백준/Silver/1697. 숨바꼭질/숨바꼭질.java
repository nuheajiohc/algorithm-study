import java.io.*;
import java.util.*;

public class Main {

    private static int[] arr;
    private static Deque<Integer> q;
    private static int s, b;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        arr = new int[100001];
        arr[s] = 1;

        q = new ArrayDeque<>();
        q.offer(s);
        while (true) {
            int cur = q.poll();
            if (check(cur, cur + 1) || check(cur, cur - 1) || check(cur, cur * 2)) {
                System.out.println(arr[b] - 1);
                break;
            }
        }

    }

    public static boolean check(int cur, int nx) {
        if (nx < 0 || nx > 100000) {
            return false;
        }
        if (arr[nx] == 0) {
            arr[nx] = arr[cur] + 1;
            q.offer(nx);
            return false;
        }
        if (nx == b) {
            return true;
        }
        return false;
    }
}
