import java.io.*;
import java.util.*;

public class Main { 
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while(T-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // 팀의 개수
            int k = Integer.parseInt(st.nextToken()); // 문제의 개수
            int t = Integer.parseInt(st.nextToken()); // 나의 팀 ID
            int m = Integer.parseInt(st.nextToken()); // 로그 개수

            Team[] teams = new Team[n+1];
            for(int i=0; i<n+1; i++){
                teams[i] = new Team(k+1);
                teams[i].id=i;
            }

            for(int i=0; i<m; i++){
                st = new StringTokenizer(br.readLine());
                int id = Integer.parseInt(st.nextToken());
                int num = Integer.parseInt(st.nextToken());
                int score = Integer.parseInt(st.nextToken());
                teams[id].lastNum = i;
                int[] scores = teams[id].score;
                teams[id].count++;
                if(scores[num]<score){
                    scores[num]=score;
                }
            }

            for(int i=1; i<n+1; i++){
                int[] scores = teams[i].score;
                for(int score : scores){
                    teams[i].totalScore +=score;
                }
            }

            int rank=1;
            for(int i=1; i<=n; i++){
                if(teams[i].id==t) continue;
                else{
                    if(teams[i].totalScore>teams[t].totalScore) rank++;
                    else if(teams[i].totalScore==teams[t].totalScore){
                        if(teams[i].count < teams[t].count) rank++;
                        else if(teams[i].count == teams[t].count){
                            if(teams[i].lastNum < teams[t].lastNum) rank++;
                        }
                    }
                }
            }
            sb.append(rank).append("\n");
        }
        System.out.println(sb);
    }

    public static class Team{
        int id;
        int count;
        int lastNum;
        int totalScore;
        int[] score;

        Team(int size){
            this.score = new int[size];
        }
    }
}
