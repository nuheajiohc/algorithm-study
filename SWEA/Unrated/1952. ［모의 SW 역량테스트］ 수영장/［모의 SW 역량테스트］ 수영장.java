import java.io.*;
import java.util.*;

public class Solution {

    static int[] price, plan;
    static int minSum;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int tc=1; tc<=TC; tc++){
            price = new int[4];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<4; i++){
                price[i] = Integer.parseInt(st.nextToken());
            }
            
            plan = new int[12];
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<12; i++){
                plan[i] = Integer.parseInt(st.nextToken());
            }
            minSum = price[3];

            permutation(0, 0);
            sb.append("#").append(tc).append(" ").append(minSum).append("\n");
        }
        System.out.println(sb);
    }

    static void permutation(int k, int sum){
        if(k>=12){
            minSum = Math.min(minSum, sum);
            return;
        }

        permutation(k+1, sum+plan[k]*price[0]);
        permutation(k+1, sum+price[1]);
        permutation(k+3, sum+price[2]);
    }
}
