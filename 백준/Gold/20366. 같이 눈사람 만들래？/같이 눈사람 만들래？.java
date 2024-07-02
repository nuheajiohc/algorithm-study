import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] radius = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            radius[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(radius);

        int minDiff=Integer.MAX_VALUE;
        boolean[] vis = new boolean[N];
        for(int i=0; i<N-1; i++){
            vis[i]=true;
            for(int j=i+3; j<N; j++){
                vis[j]=true;
                int snowman1=radius[i]+radius[j];

                int e=N-1;
                int s=0;
                while(s<e && s<j && e>i){
                    if(vis[s]){
                        s++;
                        continue;
                    }
                    if(vis[e]){
                        e--;
                        continue;
                    }
                
                    int snowman2 = radius[s]+radius[e];
                    int diff = Math.abs(snowman1-snowman2);
                    if(minDiff>diff){
                        minDiff = diff;
                    }
                    if(snowman1<snowman2){
                        e--;
                    }else if(snowman1>snowman2){
                        s++;
                    }else{
                        break;
                    }
                }
                vis[j]=false;
            }
            
            vis[i]=false;
        }
        System.out.println(minDiff);
    }
}
