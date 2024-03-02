import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int result = Integer.parseInt(br.readLine()) * Integer.parseInt(br.readLine())
                * Integer.parseInt(br.readLine());
        int[] count = new int[10];
        while (result != 0) {
            int temp = result % 10;
            result = result / 10;
            count[temp] += 1;
        }
        StringBuilder sb = new StringBuilder();
        for (int n : count) {
            sb.append(n).append("\n");
        }
        System.out.println(sb.toString());
    }
}
