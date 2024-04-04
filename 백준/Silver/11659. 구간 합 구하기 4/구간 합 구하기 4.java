import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] nums = new int[N];
        st = new StringTokenizer(br.readLine());
        nums[0]= Integer.parseInt(st.nextToken());
        for(int i=1; i<N; i++){
            nums[i] = Integer.parseInt(st.nextToken())+nums[i-1];
        }
        for(int i=0; i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            if(a==0){
                sb.append(nums[b]).append("\n");
                continue;
            }
            sb.append(nums[b]-nums[a-1]).append("\n");
        }
        System.out.println(sb.toString());
    }
}
