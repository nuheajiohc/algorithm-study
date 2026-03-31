import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        int num = 2;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                sb.append(num).append(" ");
                num+=2;
                num = num%10==0 ? 2 : num;
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}