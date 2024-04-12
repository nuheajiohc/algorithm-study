import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int minSum=Math.abs(nums[0]+nums[N-1]);
        int min=nums[0];
        int max=nums[N-1];
        int s =0;
        int e =N-1;
        while(s<e){
            if(minSum>Math.abs(nums[s]+nums[e])){
                minSum = Math.abs(nums[s]+nums[e]);
                min= nums[s];
                max= nums[e];
            }
            if(nums[s]+nums[e]<0){
                s++;
            }else{
                e--;
            }
        }
        System.out.println(min+" "+max);
    }
}
