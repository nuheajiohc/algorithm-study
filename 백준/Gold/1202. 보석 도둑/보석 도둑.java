import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<int[]> pq1 = new PriorityQueue<>((a,b)->{
            if(a[0]==b[0]) return b[1]-a[1];
            return a[0]-b[0];
        });
        Queue<int[]> pq2 = new PriorityQueue<>((a,b)->b[1]-a[1]);

        while(N-->0){
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            pq1.offer(new int[]{M,V});
        }

        List<Integer> list = new ArrayList<>();
        while(K-->0){
            list.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(list);

        long sum=0;
        for(int i=0; i<list.size();i++){
            int target = list.get(i);
            while(!pq1.isEmpty() && target>=pq1.peek()[0]){
                pq2.offer(pq1.poll());
            }
            if(pq2.isEmpty()) continue;
            sum+= pq2.poll()[1];
            
        }
        System.out.println(sum);
    }
}
