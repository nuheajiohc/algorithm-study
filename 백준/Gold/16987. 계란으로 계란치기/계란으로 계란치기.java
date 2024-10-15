import java.io.*;
import java.util.*;

public class Main {

    private static int N;
    private static Egg[] eggs;
    private static int max=0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        eggs = new Egg[N];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            eggs[i] = new Egg(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        btk(0,0);
        System.out.println(max);
    }   

    public static void btk(int depth, int count){
        if(depth == N){
            return;
        }

        if(eggs[depth].durability<=0){
            max = Math.max(max,count);
            btk(depth+1,count);
            return;
        }

        for(int i=0; i<N; i++){
            if(eggs[i].durability<=0 || i==depth) continue;
            eggs[depth].durability-=eggs[i].weight;
            eggs[i].durability-=eggs[depth].weight;

            if(eggs[depth].durability<=0){
                count+=1;
            }
            if(eggs[i].durability<=0){
                count+=1;
            }
            max = Math.max(max,count);
            btk(depth+1,count);
            if(eggs[depth].durability<=0){
                count-=1;
            }
            if(eggs[i].durability<=0){
                count-=1;
            }
            eggs[depth].durability+=eggs[i].weight;
            eggs[i].durability+=eggs[depth].weight;
        }
    }

    public static class Egg{
        int durability;
        int weight;

        Egg(int durability, int weight){
            this.durability = durability;
            this.weight = weight;
        }
    }
}
