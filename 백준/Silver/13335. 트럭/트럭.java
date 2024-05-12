import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        Deque<Integer> truck = new ArrayDeque<>();
        Deque<Integer> bridge = new ArrayDeque<>();

        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()){
            truck.offer(Integer.parseInt(st.nextToken()));
        }

        for(int i=0; i<w; i++){
            bridge.offer(0);
        }

        int totalTime=0;
        int totalWeight=0;
        while(!bridge.isEmpty()){
            totalWeight-=bridge.poll();
            totalTime++;
            if(!truck.isEmpty()){
                if(totalWeight+truck.peek()<=l){
                    bridge.offer(truck.poll());
                }else{
                    bridge.offer(0);
                }
                totalWeight+=bridge.peekLast();
            }
        }
        System.out.println(totalTime);
    }
}
