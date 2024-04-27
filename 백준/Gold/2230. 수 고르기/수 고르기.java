import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] sequence = new int[N];
        for(int i=0; i<N; i++){
            sequence[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(sequence);
        int end = 0;
        int minDiff=Integer.MAX_VALUE;
        for(int start=0; start<N; start++){
            while(end<N && sequence[end]-sequence[start]<M) end++;
            if(end == N) break;
            minDiff = Math.min(minDiff, sequence[end]-sequence[start]);
        }

        System.out.println(minDiff);
    }
}
