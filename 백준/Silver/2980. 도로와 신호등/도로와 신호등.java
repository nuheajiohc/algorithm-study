import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int time=0;
        int pos=0;

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int D = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            int G = Integer.parseInt(st.nextToken());
            time+=D-pos;
            pos=D;
            int temp= time;

            while(temp>0){
                if(temp>=R){
                    temp-=R;
                }else{
                    time+=R-temp;
                    temp=0;
                }
                if(temp>G){
                    temp-=G;
                }else if(temp<G){
                    temp=0;
                }else{
                    time+=R;
                }
            }
        }
        time+=L-pos;
        System.out.println(time);
    }
}
