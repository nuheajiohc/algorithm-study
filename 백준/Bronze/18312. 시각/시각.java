import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int count=0;
        for(int h=0; h<=N; h++){
            if(h%10==K || (h/10==K)){
                count += (60*60);
                continue;
            }
            for(int m=0; m<60; m++){
                if(m%10==K || (m/10==K)){
                    count+=60;
                    continue;
                }
                for(int s=0; s<60; s++){
                    if(s%10==K || (s/10==K)){
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
    }
}
