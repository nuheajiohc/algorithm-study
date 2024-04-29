import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue<NumberCheck> heap = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            int num = Integer.parseInt(br.readLine());   
            if(num==0){
                if(heap.isEmpty()){
                    sb.append(0).append("\n");
                }else{
                    sb.append(heap.poll().original).append("\n");
                }
                continue;
            }
            heap.offer(new NumberCheck(num));
        }
        System.out.println(sb.toString());
    }

    static class NumberCheck implements Comparable<NumberCheck>{

        int original;
        int abs;

        public NumberCheck(int original){
            this.original = original;
            this.abs = Math.abs(original);
        }

        @Override
        public int compareTo(NumberCheck o){
            if(abs>o.abs) return 1;
            else if(abs<o.abs) return -1;
            else{
                if(original>o.original) return 1;
                else if(original<o.original) return -1;
                else return 0;
            }
        }
    }
}
