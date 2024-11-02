import java.io.*;
import java.util.*;

public class Main {

    private static int N;
    private static int[] arr;
    private static int total;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = -1;
        int e =0;

        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            if(arr[i]>e){
                e=arr[i];
            }
        }

        total = Integer.parseInt(br.readLine());

        e+=1;

        while(s+1<e){
            int mid = (s+e)/2;
            if(check(mid)) s=mid;
            else e=mid;
        }
        System.out.println(s);

    }

    public static boolean check(int target){
        int sum=0;
        for(int budget : arr){
            if(budget>target){
                sum+=target;
            }else{
                sum+=budget;
            }
        }

        return sum<=total;
    }
}
