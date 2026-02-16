import java.io.*;
import java.util.*;

public class Solution {
    static int N;
    static int[] weights;
    
    static int[] fact = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};
    static int[] pow2 = {1, 2, 4, 8, 16, 32, 64, 128, 256, 512};
    static int[] pow3 = {1, 3, 9, 27, 81, 243, 729, 2187, 6561, 19683};
    
    static int[] memo; 

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            weights = new int[N];
            
            int totalWeight = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                weights[i] = Integer.parseInt(st.nextToken());
                totalWeight += weights[i];
            }

            memo = new int[pow3[N]];
            Arrays.fill(memo, -1);

            int answer = solve(0, 0, 0, 0, 0, totalWeight);
            sb.append("#").append(tc).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }

    static int solve(int nth, int usedBit, int state3, int sumL, int sumR, int remain) {
        if (sumR > sumL) return 0;
        
        if (sumL >= sumR + remain) {
            return fact[N - nth] * pow2[N - nth]; 
        }

        if (nth == N) return 1;

        if (memo[state3] != -1) {
            return memo[state3];
        }

        int count = 0;
        
        for (int i = 0; i < N; i++) {
            if ((usedBit & (1 << i)) == 0) {
                
                count += solve(nth + 1, usedBit | (1 << i), state3 + pow3[i], 
                            sumL + weights[i], sumR, remain - weights[i]);
                
                count += solve(nth + 1, usedBit | (1 << i), state3 + (2 * pow3[i]), 
                            sumL, sumR + weights[i], remain - weights[i]);
            }
        }
        
        return memo[state3] = count; 
    }
}