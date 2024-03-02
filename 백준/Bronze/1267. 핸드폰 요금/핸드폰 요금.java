import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        br.readLine();
        int Y = 0;
        int M = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            int temp = Integer.parseInt(st.nextToken());
            Y += (temp / 30 + 1) * 10;
            M += (temp / 60 + 1) * 15;
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
}
