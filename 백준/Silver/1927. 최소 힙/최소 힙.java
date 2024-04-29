import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        Queue<Integer> heap = new PriorityQueue<>();
        for(int i=0; i<N; i++){
            int num = Integer.parseInt(br.readLine());
            if(num==0){
                if(heap.isEmpty()){
                    sb.append(0).append("\n");
                }else{
                    sb.append(heap.poll()).append("\n");
                }
                continue;
            }
            heap.offer(num);
        }
        System.out.println(sb.toString());
    }
}
