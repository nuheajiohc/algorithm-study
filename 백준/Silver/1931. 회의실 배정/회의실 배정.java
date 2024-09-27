import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int  N = Integer.parseInt(br.readLine());

        int[][] time = new int[N][2];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            time[i] = new int[]{s,e};
        }

        Arrays.sort(time, (a,b)->{
            if(a[0] == b[0]){
                return a[1]-b[1];
            }
            return a[0]-b[0];
        });
        

        int count=1;
        int s = time[0][0];
        int e = time[0][1];
        for(int i=1; i<N; i++){
            if(e>time[i][1]){
                s = time[i][0];
                e = time[i][1];
                continue;
            }
            if(e<=time[i][0]){
                count++;
                s = time[i][0];
                e = time[i][1];
            }
        }
        System.out.println(count);
    }
}
