import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] nums = new long[N];
        for(int i=0; i<N; i++){
            long num = Long.parseLong(br.readLine());
            nums[i] = num;
        }
        Arrays.sort(nums);

        long value=0;
        int count=0;
        int st=0;
        int en=0;
        while(st<N){
            while(en<N-1 && nums[en]==nums[en+1]){
                en++;
            }
            if(count<en-st+1){
                count=en-st+1;
                value=nums[st];
            }
            st=en+1;
            en=st;
        }

        System.out.println(value);
    }
}
