import java.io.*;
import java.util.*;

public class Main {

    private static int N;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int[] totalScore = new int[N];
        for(int i=0; i<3; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] score = new int[N];
            for(int j=0; j<N; j++){
                score[j] = Integer.parseInt(st.nextToken());
                totalScore[j] += score[j];
            }
            rank(score);
        }
        rank(totalScore);
        System.out.println(sb.toString());
    }

    public static void rank(int[] score){
        Integer[] copyScore = new Integer[N];
        for(int i=0; i<N; i++){
            copyScore[i] = score[i];
        }
        Arrays.sort(copyScore,(a,b)->b-a);
        for(int i=0; i<N; i++){
            int st=-1;
            int en=N;
            while(st+1<en){
                int mid = (st+en)/2;
                if(copyScore[mid]<=score[i]) en=mid;
                else st=mid;
            }
            sb.append(en+1).append(" ");
        }
        sb.append("\n");
    }
}