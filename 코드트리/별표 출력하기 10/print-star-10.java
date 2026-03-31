import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int start = 1;
        int end = N;
        while(start<=N){
            for(int i=0; i<start; i++){
                sb.append("* ");
            }
            sb.append("\n");
            for(int j=0; j<end; j++){
                sb.append("* ");
            }
            sb.append("\n");
            start++;
            end--;
        }
        System.out.println(sb);
    }
}