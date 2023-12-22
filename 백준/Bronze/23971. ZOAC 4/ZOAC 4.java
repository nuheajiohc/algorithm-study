import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int a = nums[0] % (nums[2] + 1) == 0 ? nums[0] / (nums[2] + 1) : (nums[0] / (nums[2] + 1)) + 1;
        int b = nums[1] % (nums[3] + 1) == 0 ? nums[1] / (nums[3] + 1) : (nums[1] / (nums[3] + 1)) + 1;
        System.out.println(a * b);
    }
}