import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> q = new ArrayDeque<>();
        for(int i=1; i<=N; i++){
            q.offerLast(i);
        }

        while(q.size()>1){
            q.pollFirst();
            q.offerLast(q.pollFirst());
        }
        System.out.println(q.poll());
    }
}
