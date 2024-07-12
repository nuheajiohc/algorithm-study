import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<int[]> pq1 = new PriorityQueue<>((a,b)-> a[0]-b[0]);
        Queue<Integer> pq2 = new PriorityQueue<>((a,b)->b-a);

        while(N-->0){
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            pq1.offer(new int[]{M,V});
        }

        List<Integer> bags = new ArrayList<>();
        while(K-->0){
            bags.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(bags);

        long sum=0;
        for(int i=0; i<bags.size();i++){
            int target = bags.get(i);
            while(!pq1.isEmpty() && target>=pq1.peek()[0]){
                pq2.offer(pq1.poll()[1]);
            }
            if(pq2.isEmpty()) continue;
            sum+= pq2.poll();
            
        }
        System.out.println(sum);
    }
}
