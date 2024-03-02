import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        while (true) {
            StringBuilder sb = new StringBuilder(br.readLine());
            if (sb.toString().equals("0"))
                break;
            if (sb.toString().equals(sb.reverse().toString())) {
                result.append("yes").append("\n");
            } else {
                result.append("no").append("\n");
            }
        }
        System.out.println(result.toString());
    }
}
