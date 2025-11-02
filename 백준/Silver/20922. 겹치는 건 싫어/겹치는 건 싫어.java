import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] used = new int[100001];
        int max = 0;
        int start = 0;
        for(int end=0; end<N; end++){
            used[arr[end]]++;
            while(start<end && used[arr[end]]>K){
                used[arr[start]]--;
                start++;
            }
            max = Math.max(max, end-start+1);
        }

        System.out.println(max);
    }
}
