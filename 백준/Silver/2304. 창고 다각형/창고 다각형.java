import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[1001];
        while(N-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a]=b;
        }

        int[] left = new int[1001];
        left[0]=arr[0];
        for(int i=1; i<1001; i++){
            left[i] = Math.max(left[i-1], arr[i]);
        }

        int[] right = new int[1001];
        right[1000]=arr[1000];
        for(int i=999; i>=0; i--){
            right[i] = Math.max(right[i+1], arr[i]);
        }

        int area=0;
        for(int i=0; i<1001; i++){
            area+=Math.min(left[i], right[i]);
        }
        System.out.println(area);
    }
}
