import java.util.*;
import java.io.*;

public class Main {

    private static int N, X;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(st.nextToken());
            if (X > temp) {
                sb.append(temp);
                sb.append(" ");
            }
        }
        System.out.println(sb.toString());
    }
}