import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        List<Integer> order = new LinkedList<>();

        for(int i=1; i<=N;i++){
            int s = Integer.parseInt(st.nextToken());
            order.add(order.size()-s,i);
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            sb.append(order.get(i)).append(" ");
        }
        System.out.println(sb);
    }
}
