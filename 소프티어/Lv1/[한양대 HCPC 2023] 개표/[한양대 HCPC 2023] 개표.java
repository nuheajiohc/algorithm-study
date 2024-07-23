import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while(T-->0){
            int N = Integer.parseInt(br.readLine());
            int a = N/5;
            int b = N%5;
            while(a-->0){
                sb.append("+".repeat(4)).append(" ");
            }
            sb.append("|".repeat(b));
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
