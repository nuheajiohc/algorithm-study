import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        String A = br.readLine();
        String B = br.readLine();

        int[] alphabet = {3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1};
        Queue<Integer> queue = new ArrayDeque<>();
        for(int i=0; i<A.length(); i++){
            queue.offer(alphabet[A.charAt(i)-'A']);
            queue.offer(alphabet[B.charAt(i)-'A']);
        }

        while(queue.size()>2){
            int qSize=queue.size()-1;
            while(qSize-->0){
                queue.offer((queue.poll()+queue.peek())%10);
            }
            queue.poll();
        }
        System.out.println(""+queue.poll()+queue.poll());
    }
}
