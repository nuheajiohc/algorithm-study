import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int max = 0;
        int count = 0;
        while(st.hasMoreTokens()){
            int value = Integer.parseInt(st.nextToken());
            if(max < value){
                max = value;
                count = 1;
            }else if(max == value){
                count++;
            }
        }

        if(count==1){
            System.out.println(max);
        }else{
            System.out.println(-1);
        }
    }
}