import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nums = new int[5];
        int sum = 0;
        for (int i = 0; i < 5; i++) {
            nums[i] = Integer.parseInt(br.readLine());
            sum += nums[i];
        }
        Arrays.sort(nums);
        System.out.println(sum / 5);
        System.out.println(nums[2]);
    }
}
