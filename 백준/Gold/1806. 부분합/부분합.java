import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =  new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st= new StringTokenizer(br.readLine());
        int[] sequence = new int[N+1];
        for(int i=1; i<=N; i++){
            sequence[i] = Integer.parseInt(st.nextToken())+sequence[i-1];
        }
        int minLength = N+1;
        int end=1;
        for(int start=0; start<=N; start++){
            while(end<N+1 && sequence[end]-sequence[start]<M) end++;
            if(end==N+1) break;
            minLength = Math.min(minLength, end-start);
        }

        System.out.println(minLength==N+1?0:minLength);
    }
}
