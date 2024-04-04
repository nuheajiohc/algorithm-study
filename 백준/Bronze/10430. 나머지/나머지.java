import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        sb.append((A+B)%C).append("\n")
          .append(((A%C) + (B%C))%C).append("\n")
          .append( (A*B)%C).append("\n")
          .append( ((A%C) * (B%C))%C).append("\n");

        System.out.println(sb.toString());
    }
}
