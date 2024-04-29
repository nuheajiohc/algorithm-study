import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> heap = new PriorityQueue<>();
        for(int i=0; i<N; i++){
            heap.offer(Integer.parseInt(br.readLine()));
        }
        if(N==1){
            System.out.println(0);
            return;
        }

        int sum=0;
        while(!heap.isEmpty()){
            int temp = heap.poll() + heap.poll();
            sum+=temp;
            if(heap.isEmpty()) break;
            heap.offer(temp);
        }
        System.out.println(sum);
    }
}
