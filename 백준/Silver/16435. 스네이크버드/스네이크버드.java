import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int[] h = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            h[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(h);

        int result=L;
        for(int i=0; i<N; i++){
            if(result>= h[i]) result++;
            else break;
        }
        System.out.println(result);

    }
}
