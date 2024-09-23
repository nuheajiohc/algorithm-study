import java.util.*;
import java.io.*;

public class Main {

   private static int N;
   private static Food[] foods;
   private static int minDiff = Integer.MAX_VALUE;
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

      getMinDiff(0,1,0);
      System.out.println(minDiff);
   }

   public static void getMinDiff(int k, int curSour, int curBitter){
      if(k>=N){
         if(curBitter==0) return;
         minDiff = Math.min(minDiff, Math.abs(curSour-curBitter));
         return;
      }

      getMinDiff(k+1,curSour,curBitter);
      getMinDiff(k+1,curSour*foods[k].sour, curBitter+foods[k].bitter);
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
