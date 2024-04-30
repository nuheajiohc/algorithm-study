import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> heap = new PriorityQueue<>((a,b)->b-a);

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            int num = Integer.parseInt(br.readLine());
            if(num==0){
                if(heap.isEmpty()){
                    sb.append(0);
                }else{
                    sb.append(heap.poll());
                }
                sb.append("\n");
            }else{
                heap.offer(num);
            }
        }
        System.out.println(sb.toString());
    }
}
