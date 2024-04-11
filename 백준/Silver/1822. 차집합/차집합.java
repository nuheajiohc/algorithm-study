import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<Integer> set = new HashSet<>();
        br.readLine();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] nums = new int[st.countTokens()];
        for(int i=0;i<nums.length; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);
        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()){
            set.add(Integer.parseInt(st.nextToken()));
        }

        StringBuilder sb = new StringBuilder();
        int count=0;
        for(int i=0; i<nums.length; i++){
            if(!set.contains(nums[i])){
                count++;
                sb.append(nums[i]).append(" ");
            }
        }
        if(sb.length()==0){
            System.out.println(0);
        }else{
            System.out.println(count);
            System.out.println(sb.toString());
        }
    }
}
