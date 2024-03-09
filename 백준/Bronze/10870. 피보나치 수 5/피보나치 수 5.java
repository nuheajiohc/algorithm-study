import java.io.*;

public class Main {
    private static int[] nums = new int[21];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        nums[0] = 0;
        nums[1] = 1;
        nums[2] = 1;
        System.out.println(fibo(n));
    }

    public static int fibo(int n) {
        if (n == 0) {
            return 0;
        }
        if (nums[n] == 0) {
            return fibo(n - 1) + fibo(n - 2);
        }
        return nums[n];
    }
}
