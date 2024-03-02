import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        String[] nums = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17",
                "18", "19", "20" };
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            reverse(nums, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        System.out.println(String.join(" ", nums));
    }

    public static void reverse(String[] nums, int a, int b) {
        for (int i = a; i <= (a + b) / 2; i++) {
            String temp = nums[i - 1];
            nums[i - 1] = nums[a + b - i - 1];
            nums[a + b - i - 1] = temp;
        }
    }
}
