import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st= new StringTokenizer(br.readLine());
        long[] nums= new long[N];
        for(int i=0; i<N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        long sum=3000000001L;
        long min=0;
        long mid=0;
        long max=0;
        Arrays.sort(nums);
        for(int i=0; i<N-2; i++){
            int s=i+1;
            int e=N-1;
            while(s<e){
                if(Math.abs(nums[i]+nums[s]+nums[e])<sum){
                    sum = Math.abs(nums[i]+nums[s]+nums[e]);
                    min = nums[i];
                    mid = nums[s];
                    max = nums[e];
                }

                if(nums[i]+nums[s]+nums[e]<0) s++;
                else e--;
            }
        }
        System.out.println(min+" "+mid+" "+max);
    }
}
