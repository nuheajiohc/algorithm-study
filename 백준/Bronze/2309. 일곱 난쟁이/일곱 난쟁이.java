import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nums = new int[9];
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            nums[i] = Integer.parseInt(br.readLine());
            sum += nums[i];
        }
        Arrays.sort(nums);
        for (int i = 0; i < 8; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (sum - nums[i] - nums[j] == 100) {
                    for (int k = 0; k < 9; k++) {
                        if (k == i || k == j)
                            continue;
                        System.out.println(nums[k]);
                    }
                    return;
                }
            }
        }
    }
}