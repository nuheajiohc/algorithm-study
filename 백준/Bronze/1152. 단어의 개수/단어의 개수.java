import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        if (s.equals(" ")) {
            System.out.println(0);
            return;
        }
        System.out.println(s.trim().split(" ").length);
    }
}
