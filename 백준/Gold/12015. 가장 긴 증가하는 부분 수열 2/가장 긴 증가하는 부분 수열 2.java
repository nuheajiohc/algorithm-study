import java.io.*;
import java.util.*;

public class Main {

    private static int[] memo;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        memo = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        int length=0;
        int idx=0;
        for(int i=0; i<N; i++){
            int num = Integer.parseInt(st.nextToken());
            if(num>memo[length]){
                memo[++length] = num;
            }else{
                idx = lowerBound(length,num);
                memo[idx] = num;
            }
        }
        System.out.println(length);
    }

    public static int lowerBound(int length, int target){
        int st = 0;
        int en = length;
        while(st+1<en){
            int mid = (st+en)/2;
            if(target>memo[mid]) st = mid;
            else en = mid;
        }
        return en;
    }
}
