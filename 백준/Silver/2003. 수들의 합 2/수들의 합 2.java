import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new  StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] sequence = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            sequence[i] = Integer.parseInt(st.nextToken());
        }

        int totalSum =sequence[0];
        int count=0;
        int end=0;
        for(int start=0; start<N; start++){
            while(end<N-1 && totalSum<M){
                end++;
                totalSum+=sequence[end];
            }
            if(totalSum==M) count++;
            if(end==N) break;
            totalSum-=sequence[start];
        }

        System.out.println(count);
    }
}
