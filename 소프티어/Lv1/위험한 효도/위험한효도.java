import java.io.*;
import java.util.*;

public class Main {

    private static int a,b,d,time,namwu;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        while(true){
            walk(a);
            if(namwu==0) break;
            stop(b);
        }
        while(true){
            walk(b);
            if(namwu==0) break;
            stop(a);
        }
        System.out.println(time);
    }

    public static void walk(int x){
        if(namwu+x>=d){
            time+=d-namwu;
            namwu=0;
        }else{
            time+=x;
            namwu+=x;
        }
    }

    public static void stop(int x){
        time+=x;
    }
}
