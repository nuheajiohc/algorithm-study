import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int max=0;
        String bench = br.readLine();
        boolean[] vis = new boolean[N];
        for(int i=0; i<N; i++){
            if(bench.charAt(i)=='P'){
                for(int j=i-K; j<=i+K; j++){
                    if(j>=0 && j<N && !vis[j] && bench.charAt(j)=='H'){
                        vis[j]= true;
                        max++;
                        break;
                    }
                }
            }
        }
        System.out.println(max);
    }
}
