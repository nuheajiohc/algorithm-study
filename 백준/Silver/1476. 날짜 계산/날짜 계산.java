import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int E = Integer.parseInt(st.nextToken())%15;
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken())%19;

        int year = S;
        while(!(year%15==E && year%19==M)){
            year+=28;
        }
        System.out.println(year);
    }
}