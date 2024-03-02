import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int Y = 0;
        int M = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            double temp = Double.parseDouble(st.nextToken());
            Y += count(temp, 30) * 10;
            M += count(temp, 60) * 15;
        }

        if (Y > M) {
            sb.append("M ").append(M);
        } else if (Y < M) {
            sb.append("Y ").append(Y);
        } else {
            sb.append("Y M ").append(M);
        }
        System.out.println(sb);
    }

    public static int count(double temp, int standard) {
        return (int) Math.floor((temp / standard) + 1);
    }
}
