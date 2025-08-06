import java.io.*;
import java.util.*;

public class Main {

    private static int[] arr;
    private static int N,M;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int s = underbound(a);
            int e = upperbound(b);
            sb.append(e-s-1).append("\n");
        }

        System.out.println(sb.toString());
    }

    public static int underbound(int n){
        int st = -1;
        int en = N;
        while(st+1<en){
            int mid = (st+en)/2;
            if(arr[mid]<n) st = mid;
            else en = mid;
        }

        return st;
    }

    public static int upperbound(int n){
        int st = -1;
        int en = N;
        while(st+1<en){
            int mid = (st+en)/2;
            if(arr[mid]<=n) st = mid;
            else en = mid;
        }

        return en;
    }
}
