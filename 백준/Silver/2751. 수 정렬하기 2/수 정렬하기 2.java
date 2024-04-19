import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer> nums = new ArrayList<>();
        for(int i=0; i<N; i++){
            nums.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(nums);
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            sb.append(nums.get(i)).append("\n");
        }
        System.out.println(sb.toString());

    }
}
