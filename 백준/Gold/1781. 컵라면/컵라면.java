import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Queue<Problem> pq1 = new PriorityQueue<>((a,b)->{
            if(a.deadLine != b.deadLine){
                return a.deadLine - b.deadLine;
            }else{
                return b.cupNoodle - a.cupNoodle;
            }
        });
        while(N-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int deadLine = Integer.parseInt(st.nextToken());
            int cupNoodle = Integer.parseInt(st.nextToken());
            pq1.offer(new Problem(deadLine, cupNoodle));
        }

        Queue<Problem> pq2 = new PriorityQueue<>((a,b)->a.cupNoodle-b.cupNoodle);
        while(!pq1.isEmpty()){
            Problem problem = pq1.poll();
            if(problem.deadLine>pq2.size()){
                pq2.offer(problem);
            }else{
                if(!pq2.isEmpty()&&problem.cupNoodle>pq2.peek().cupNoodle){
                    pq2.poll();
                    pq2.offer(problem);
                }
            }
        }
        int maxCupNoodle=0;
        while(!pq2.isEmpty()){
            maxCupNoodle+= pq2.poll().cupNoodle;
        }

        System.out.println(maxCupNoodle);
    }

    public static class Problem{
        int deadLine;
        int cupNoodle;

        Problem(int deadLine, int cupNoodle){
            this.deadLine =deadLine;
            this.cupNoodle = cupNoodle;
        }
    }
}
