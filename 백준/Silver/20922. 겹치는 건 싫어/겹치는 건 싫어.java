import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] count = new int[100001];
        int result=0;
        int max=1;
        int s=0;
        count[arr[s]]++;
        for(int e=1; e<N; e++){
            count[arr[e]]++;
            max++;
            while(count[arr[e]]>M){    
                count[arr[s]]--;
                max--;
                s++;
            }
            result = Math.max(result, max);
        }
        System.out.println(result);  
    }
}
