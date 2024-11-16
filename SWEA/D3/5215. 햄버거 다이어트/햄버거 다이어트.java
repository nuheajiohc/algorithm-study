import java.io.*;
import java.util.*;

public class Solution {

    private static Food[] foods;
    private static int N, L;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int t=1; t<=T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
            foods = new Food[N];
            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                int score = Integer.parseInt(st.nextToken());
                int kcal = Integer.parseInt(st.nextToken());
                foods[i] = new Food(score, kcal);
            }
            int result = btk(0,0,0);

            sb.append("#").append(t).append(" ").append(result).append("\n");
        }

        System.out.println(sb);
    }

    public static int btk(int depth, int totalScore, int totalKcal){
        if(depth==N){
            if(totalKcal<=L){
                return totalScore;
            }else
                return 0;
        }
        int max = btk(depth+1, totalScore+foods[depth].score, totalKcal+foods[depth].kcal);
        max = Math.max(max, btk(depth+1, totalScore, totalKcal));
        return max;
    }

    public static class Food{
        int score;
        int kcal;

        public Food(int score, int kcal) {
            this.score = score;
            this.kcal = kcal;
        }
    }
}
