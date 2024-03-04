import java.io.*;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        String firstS = br.readLine();
        String secondS = br.readLine();
        int[] firstArr = returnArr(firstS);
        int[] secondArr = returnArr(secondS);
        int count = 0;
        for (int i = 0; i < 26; i++) {
            count += 2 * Math.min(firstArr[i], secondArr[i]);
        }
        System.out.println(firstS.length() + secondS.length() - count);

    }

    public static int[] returnArr(String s) {
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;

        }
        return arr;
    }
}
