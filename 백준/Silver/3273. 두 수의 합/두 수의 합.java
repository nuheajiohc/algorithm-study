import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        String[] array = br.readLine().split(" ");
        int[] nums = new int[2000001];
        for (int i = 0; i < array.length; i++) {
            nums[Integer.parseInt(array[i])] = 1;
        }
        int x = Integer.parseInt(br.readLine());

        int count = 0;
        for (String s : array) {
            int temp = x - Integer.parseInt(s);
            if (temp > 0 && (temp * 2 != x) && nums[temp] == 1) {
                count++;
            }
        }
        System.out.println(count / 2);
    }
}
