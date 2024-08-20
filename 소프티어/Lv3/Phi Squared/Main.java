import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayDeque<Organism> leftDeque = new ArrayDeque<>();
        ArrayDeque<Organism> rightDeque = new ArrayDeque<>();
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            int size = Integer.parseInt(st.nextToken());
            rightDeque.offer(new Organism(i+1, size));
        }
        
        while(rightDeque.size()>1){
            while(!rightDeque.isEmpty()){
                Organism curOrga = rightDeque.poll();
                long size = curOrga.size;
                if(!leftDeque.isEmpty() && leftDeque.peekLast().size<=size){
                    Organism prevOrga = leftDeque.pollLast();
                    curOrga.size += prevOrga.size;
                }

                if(!rightDeque.isEmpty() && rightDeque.peek().size<=size){
                    Organism nextOrga = rightDeque.poll();
                    curOrga.size += nextOrga.size;
                }
                leftDeque.offer(curOrga);
            }
            rightDeque = leftDeque;
            leftDeque = new ArrayDeque<>();
        }

        Organism organism = rightDeque.poll();
        System.out.println(organism.size);
        System.out.println(organism.index);
    }

    public static class Organism{
        int index;
        long size;

        public Organism(int index, long size){
            this.index =index;
            this.size= size;
        }
    }
}