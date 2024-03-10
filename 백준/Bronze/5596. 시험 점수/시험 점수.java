import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] minguk = br.readLine().split(" ");
        String[] manse = br.readLine().split(" ");

        int minguk_sum = 0;
        int manse_sum = 0;
        for (int i = 0; i < 4; i++) {
            minguk_sum += Integer.parseInt(minguk[i]);
            manse_sum += Integer.parseInt(manse[i]);
        }
        System.out.println(Math.max(minguk_sum, manse_sum));
    }
}
