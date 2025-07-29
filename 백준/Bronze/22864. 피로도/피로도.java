import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        if(A>M){
            System.out.println(0);
            return;
        }

        int fatigue = 0;
        int work = 0;
        for(int t=1; t<=24; t++){
            if(fatigue+A<=M){
                fatigue+=A;
                work+=B;
            }else{
                fatigue = Math.max(fatigue-C, 0);
            }
        }
        System.out.println(work);
    }
}
