import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] sequence = new int[N];
        for(int i=0; i<N; i++){
            sequence[i] = Integer.parseInt(st.nextToken());
        }

        int[] answer = new int[N];
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i=N-1; i>=0; i--){
            while(!stack.isEmpty()&&stack.peekLast()<=sequence[i]){
                stack.pollLast();
            }
            if(stack.isEmpty()){
                answer[i]=-1;
            }else{
                answer[i]=stack.peekLast();
            }
            stack.offerLast(sequence[i]);
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            sb.append(answer[i]).append(" ");
        }
        System.out.println(sb.toString());
    }
}
