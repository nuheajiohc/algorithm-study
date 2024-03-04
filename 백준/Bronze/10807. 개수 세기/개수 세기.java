import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(br.readLine());
        int count = 0;
        while (st.hasMoreTokens()) {
            if (Integer.parseInt(st.nextToken()) == v) {
                count++;
            }
        }
        System.out.println(count);
    }
}
