import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> leftHeap = new PriorityQueue<>((a,b)->b-a);
        Queue<Integer> rightHeap = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            int num = Integer.parseInt(br.readLine());
            if(leftHeap.isEmpty() || num<=leftHeap.peek()){
                leftHeap.offer(num);
            }else{
                rightHeap.offer(num);
            }

            if(leftHeap.size()>rightHeap.size()+1){
                rightHeap.offer(leftHeap.poll());
            }else if(rightHeap.size()>=leftHeap.size()+1){
                leftHeap.offer(rightHeap.poll());
            }

            sb.append(leftHeap.peek()).append("\n");
        }
        System.out.println(sb.toString());
    }
}
