import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        String pos = br.readLine();
        boolean[] vis = new boolean[N];
        
        int count=0;
        for(int i=0; i<N; i++){
            if(vis[i]) continue;
            for(int move=1; move<=K; move++){
                if(i+move>=N) break;
                if(vis[i+move]) continue;
                if(pos.charAt(i)!=pos.charAt(i+move)){
                    vis[i]=true;
                    vis[i+move]=true;
                    count++;
                    break;
                }
            }
        }
        System.out.println(count);
    }
}
