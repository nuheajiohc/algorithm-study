import java.io.*;
import java.util.*;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 3; i++) {
            count();
        }
    }

    public static void count() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int front = 0;
        for (int i = 0; i < 4; i++) {
            if (st.nextToken().equals("0")) {
                front++;
            }
        }
        judge(front);
    }

    public static void judge(int count) {
        if (count == 0) {
            System.out.println("E");
        } else if (count == 1) {
            System.out.println("A");
        } else if (count == 2) {
            System.out.println("B");
        } else if (count == 3) {
            System.out.println("C");
        } else {
            System.out.println("D");
        }
    }
}
