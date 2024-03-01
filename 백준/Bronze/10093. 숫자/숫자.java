import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] a = br.readLine().split(" ");
        long minV = Math.min(Long.parseLong(a[0]), Long.parseLong(a[1]));
        long maxV = Math.max(Long.parseLong(a[0]), Long.parseLong(a[1]));
        if (minV == maxV) {
            System.out.println(0);
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (long i = minV + 1; i < maxV; i++) {
            sb.append(i).append(" ");
        }
        System.out.println(maxV - minV - 1);
        System.out.println(sb);
    }
}
