import java.io.*;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            judge();
        }
        System.out.println(sb.toString());
    }

    public static void judge() throws Exception {
        String[] s = br.readLine().split(" ");
        String a = s[0];
        String b = s[1];
        char[] alpha = new char[26];

        if (a.length() != b.length()) {
            sb.append("Impossible").append("\n");
            return;
        }

        for (int i = 0; i < a.length(); i++) {
            alpha[a.charAt(i) - 'a']++;
        }

        for (int i = 0; i < b.length(); i++) {
            if (alpha[b.charAt(i) - 'a'] > 0) {
                alpha[b.charAt(i) - 'a']--;
            } else {
                sb.append("Impossible").append("\n");
                return;
            }
        }
        sb.append("Possible").append("\n");
    }
}
