import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        
        int[] sequence = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            sequence[i] = Integer.parseInt(st.nextToken());
        }

        Deque<Integer> deque = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            if(i>=L && sequence[i-L]==deque.peekFirst()){
                deque.pollFirst();
            }
            while(!deque.isEmpty() && deque.peekLast()>sequence[i]){
                deque.pollLast();
            }
            deque.offer(sequence[i]);
            sb.append(deque.peekFirst()).append(" ");
        }

        System.out.println(sb.toString());
    }
}
