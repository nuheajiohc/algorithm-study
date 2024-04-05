import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Deque<Integer> q = new ArrayDeque<>();
        List<Integer> answer = new ArrayList<>();
        for(int i=1; i<=N; i++){
            q.offer(i);
        }
        while(!q.isEmpty()){
            for(int i=0; i<K-1; i++){
                q.offer(q.poll());
            }
            answer.add(q.poll());
        }

        String s = answer.toString();
        System.out.println("<"+s.substring(1,s.length()-1)+">");
    }
}
