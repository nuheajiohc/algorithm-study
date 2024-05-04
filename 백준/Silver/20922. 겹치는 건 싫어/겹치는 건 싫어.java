import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] sequence = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            sequence[i] = Integer.parseInt(st.nextToken());
        }

        int maxLength=1;
        int[] check = new int[100001];
        int s=1;
        for(int e=1; e<=N; e++){
            check[sequence[e]]++;
            while(check[sequence[e]]>K){
                check[sequence[s]]--;
                s++;
            }
            maxLength=Math.max(maxLength,e-s+1);
        }

        System.out.println(maxLength);
    }   
}
