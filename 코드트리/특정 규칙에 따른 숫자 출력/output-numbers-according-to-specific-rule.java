import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int value = 1;
        for(int i=0; i<N; i++){
            for(int j=0; j<i; j++){
                sb.append("  ");
            }

            for(int j=i; j<N; j++){
                sb.append(value).append(" ");
                value++;
                if(value==10) value = 1;
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}