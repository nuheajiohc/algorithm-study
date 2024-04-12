import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] nums = new int[N];
        for(int i=0; i<N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        int minValue = Integer.MAX_VALUE;
        int min=0;
        int max=0;
        for(int i=0; i<N-1; i++){
            int s = i;
            int e = N;
            while(s+1<e){
                int mid = (s+e)/2;
                if((nums[i]+nums[mid])<0) s= mid;
                else e= mid;
                if(minValue>Math.abs(nums[i]+nums[mid])){
                    minValue = Math.abs(nums[i]+nums[mid]);
                    min=nums[i];
                    max=nums[mid];
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(min).append(" ").append(max);
        System.out.println(sb.toString());
    }
}
