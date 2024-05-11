import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] sequence = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int maxNum=0;
        for(int i=0; i<N; i++){
            sequence[i] = Integer.parseInt(st.nextToken());
            maxNum = Math.max(maxNum, sequence[i]);
        }

        boolean[] vis = new boolean[maxNum+1];
        long count=0;
        int e=0;
        for(int s=0; s<N; s++){
            while(e<N && !vis[sequence[e]]){
                vis[sequence[e]]=true;
                count+=e-s+1;
                e++;
            }
            vis[sequence[s]]=false;
        }
        System.out.println(count);
    }
}
