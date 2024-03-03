import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nums = new int[10];
        String s = br.readLine();
        for (int i = 0; i < s.length(); i++) {
            int n = s.charAt(i) - '0';
            if (n == 6 || n == 9) {
                if (nums[6] < nums[9]) {
                    nums[6]++;
                } else {
                    nums[9]++;
                }
            } else {
                nums[n]++;
            }
        }
        int result = 0;
        for (int i = 0; i < 10; i++) {
            if (result < nums[i])
                result = nums[i];
        }
        System.out.println(result);
    }
}
