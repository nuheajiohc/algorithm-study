import java.io.*;
import java.util.*;

public class Main {
    
    private static int N;
    private static Food[] foods;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        foods = new Food[N];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int sour = Integer.parseInt(st.nextToken());
            int bitter = Integer.parseInt(st.nextToken());
            foods[i] = new Food(sour, bitter);
        }

        int minDiff = getMinDiff(0,1,0);
        System.out.println(minDiff);
    }

    public static int getMinDiff(int k, int curSour, int curBitter){
        if(k==N){
            if(curBitter==0) return Integer.MAX_VALUE;
            return Math.abs(curSour-curBitter);
        }
        
        int nonInclude = getMinDiff(k+1, curSour, curBitter);
        int include = getMinDiff(k+1, curSour*foods[k].sour,curBitter+foods[k].bitter);
        int minDiff = Math.min(nonInclude, include);
        return minDiff;
    }

    public static class Food{
        int sour;
        int bitter;

        Food(int sour, int bitter){
            this.sour = sour;
            this.bitter = bitter;
        }
    }
}
