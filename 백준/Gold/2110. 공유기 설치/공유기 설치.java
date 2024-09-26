import java.io.*;
import java.util.*;

public class Main {

    private static int N,C;
    private static int[] arr;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int s=0;
        int e=1000000001;
        while(s+1<e){
            int mid = (s+e)/2;
            if(check(mid)) s=mid;
            else e=mid;
        }
        System.out.println(s);
    }

    public static boolean check(int distance){
        int count = 1;
        int st =0;
        for(int en=1; en<N; en++){
            if(arr[en]-arr[st]>=distance){
                st=en;
                count++;
            }
        }
        if(count<C) return false;
        return true;
    }
}
