import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int min = 1;
        int max = 1000;

        while(st.hasMoreTokens()){
            int value = Integer.parseInt(st.nextToken());
            if(min<value && value<500){
                min = value;
            }

            if(max>value && value>500){
                max = value;
            }
        }

        System.out.println(min + " " + max);
    }
}