import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> heap = new PriorityQueue<>((a,b)->b-a);
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()){
                heap.offer(Integer.parseInt(st.nextToken()));
            }
        }
        for(int i=0; i<N-1;i++){
            heap.poll();
        }
        System.out.println(heap.poll());
    }
}
