import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int TC = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int tc=1; tc<=TC; tc++){
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];

            int max = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                arr[i] = Integer.parseInt(st.nextToken());
                max = Math.max(arr[i], max);
            }

            int day1 = 0;
            int day2 = 0;

            for(int h : arr){
                int diff = max - h;
                day2 += diff/2;
                day1 += diff%2;
            }

            if(day1+1 < day2){
                int diff = day2 - day1;

                int k = (diff + 1) / 3;
                day2 -= k;
                day1 += 2 * k;
            }

            int answer = 0;

            if(day1 > day2){
                answer = day1*2 -1;
            } else{
                answer = day2 * 2;
            }

            sb.append("#").append(tc).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }
}
