import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        String[] str = new String[N];
        int[] score = new int[N];
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int max = Integer.parseInt(st.nextToken());
            str[i] = name;
            score[i] = max;
        }

        StringBuilder sb = new StringBuilder();
        while(M-->0){
            int strength = Integer.parseInt(br.readLine());
            int s = -1;
            int e = N-1;
            while(s+1<e){
                int mid = (s+e)/2;
                if(score[mid]<strength) s = mid;
                else e=mid;
            }
            sb.append(str[e]).append("\n");
        }
        System.out.println(sb);

    }
}
