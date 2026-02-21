import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int cnt = 0;
        for(int year=1; year<=N; year++){
            if(year%4==0 && !(year%100==0 && year%400!=0)) cnt++;
        }
        System.out.println(cnt);
    }
}