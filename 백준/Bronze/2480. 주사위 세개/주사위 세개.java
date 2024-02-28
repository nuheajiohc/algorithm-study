import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        int[] nums = new int[3];
        Scanner sc = new Scanner(System.in);
        nums[0] = sc.nextInt();
        nums[1] = sc.nextInt();
        nums[2] = sc.nextInt();

        Arrays.sort(nums);

        if (nums[0] == nums[2]) {
            System.out.println(10000 + nums[0] * 1000);
        } else if (nums[0] != nums[1] && nums[1] != nums[2]) {
            System.out.println(nums[2] * 100);
        } else {
            System.out.println(1000 + nums[1] * 100);
        }
        sc.close();
    }
}