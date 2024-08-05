import java.io.*;
import java.util.*;

public class Main {

    private static int n,q;
    private static int[] cars;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());
        cars = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            cars[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(cars);

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<q; i++){
            int target = Integer.parseInt(br.readLine());
            int idx = binarysearch(target);
            if(idx==-1){
                sb.append(0).append("\n");
            }else{
                sb.append((idx-0)*(n-1-idx)).append("\n");
            }
        }
        System.out.println(sb.toString());
    }

    public static int binarysearch(int target){
        int st=0;
        int en=n-1;
        while(st+1<en){
            int mid = (st+en)/2;
            if(target<=cars[mid]) en = mid;
            else st = mid;
        }
        if(cars[en]==target){
            return en;
        }else{
            return -1;
        }
    }
}