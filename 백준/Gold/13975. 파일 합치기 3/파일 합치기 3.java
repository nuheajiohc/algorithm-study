import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(T-->0){
            br.readLine();
            Queue<Long> heap = new PriorityQueue<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()){
                heap.offer(Long.parseLong(st.nextToken()));
            }
            long minCost = 0;
            while(heap.size()>1){
                long temp=heap.poll()+heap.poll();
                minCost +=temp;
                heap.offer(temp);
            }
            sb.append(minCost).append("\n");
        }
        System.out.println(sb.toString());
    }
}
