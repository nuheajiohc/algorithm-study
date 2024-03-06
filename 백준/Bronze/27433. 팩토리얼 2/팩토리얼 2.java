import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        factorial(n, 1);
    }

    public static void factorial(int n, long result) {
        if (n == 0) {
            System.out.println(result);
            return;
        }
        factorial(n - 1, result * n);
    }
}
