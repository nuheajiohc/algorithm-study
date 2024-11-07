import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int result=1;
        int max=1;
        int[] kinds = new int[d+1];
        kinds[c]=1;
        for(int i=0;i<k; i++){
            if(kinds[arr[i]]==0) max++;
            kinds[arr[i]]++;
        }
        result = Math.max(result, max);
        for(int s=1; s<N; s++){
            kinds[arr[s-1]]--;
            if(kinds[arr[s-1]]==0) max--;
            if(kinds[arr[(s+k-1)%N]]==0)max++;
            kinds[arr[(s+k-1)%N]]++;
            result = Math.max(result, max);
        }
        System.out.println(result);
    }
}