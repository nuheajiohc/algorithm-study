import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Deque<Balloon> deque = new ArrayDeque<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            deque.offer(new Balloon(i, Integer.parseInt(st.nextToken())));
        }

        StringBuilder sb = new StringBuilder();


        Balloon balloon = deque.pollFirst();
        sb.append(balloon.pos).append(" ");
        while(!deque.isEmpty()){
            if(balloon.value>0){
                while(--balloon.value>0){
                    deque.offerLast(deque.pollFirst());
                }
            }else{
                while(balloon.value++<0){
                    deque.offerFirst(deque.pollLast());
                }
            }
            balloon = deque.pollFirst();
            sb.append(balloon.pos).append(" ");
        }

        System.out.println(sb);
    }

    public static class Balloon{
        int pos;
        int value;

        public Balloon(int pos, int value){
            this.pos = pos;
            this.value = value;
        }
    }
}