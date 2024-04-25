import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(T-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            List<Integer> list = new ArrayList<>();
            Deque<int[]> q = new ArrayDeque<>();
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                int num = Integer.parseInt(st.nextToken());
                q.offer(new int[]{num,i});
                list.add(num);
            }

            Collections.sort(list,(a,b)->b-a);
            int count=0;
            Deque<Integer> uq= new ArrayDeque<>(list);
            while(true){
                if(uq.peek()>q.peek()[0]){
                    q.offer(q.poll());
                }else{
                    int[] num = q.poll();
                    uq.poll();
                    count++;
                    if(num[1]==M){
                        sb.append(count).append("\n");
                        break;
                    }
                }
            }
        }
        System.out.println(sb.toString());
    }
}
