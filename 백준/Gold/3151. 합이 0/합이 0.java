import java.util.*;
import java.io.*;

public class Main {

    private static int[] nums;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        nums = new int[N];
        for(int i=0; i<N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);
        long sum=0;
        for(int i=0; i<N-1; i++){
            for(int j=i+1; j<N; j++){
                int target = (nums[i]+nums[j])*-1;
                sum+=upperVal(j,target)-lowerVal(j,target);
            }
        }
        System.out.println(sum);
    }

    public static int upperVal(int j, int target){
        int st = j;
        int en = nums.length;
        while(st+1<en){
            int mid = (st+en)/2;
            if(nums[mid]<=target) st=mid;
            else en=mid;
        }
        return en;
    }

    public static int lowerVal(int j, int target){
        int st = j;
        int en = nums.length;
        while(st+1<en){
            int mid = (st+en)/2;
            if(nums[mid]<target) st = mid;
            else en =mid;
        }
        return en;
    }
}
