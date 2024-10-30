import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(T-->0){
            int N = Integer.parseInt(br.readLine());
            Map<Integer,List<Integer>> memberCount = new HashMap<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] members = new int[N];
            for(int i=0; i<N; i++){
                int team = Integer.parseInt(st.nextToken());
                members[i] = team;
                if(!memberCount.containsKey(team)){
                    memberCount.put(team, new ArrayList<>());
                }
                memberCount.get(team).add(i);
            }

            int[] scores = new int[N];
            int count=1;
            for(int i=0; i<N; i++){
                if(memberCount.get(members[i]).size()<6) continue;
                scores[i] = count;
                count++;
            }

            int winner=0;
            int score=Integer.MAX_VALUE;
            int fifth=0;
            for(int team : memberCount.keySet()){
                if(memberCount.get(team).size()<6) continue;
                int sum=0;
                for(int i=0; i<4; i++){
                    sum += scores[memberCount.get(team).get(i)];
                }
                int curFifth = scores[memberCount.get(team).get(4)];
                if(score>sum){
                    score = sum;
                    winner = team;
                    fifth = curFifth;
                }else if(score==sum){
                    if(fifth>curFifth){
                        winner = team;
                        fifth = curFifth;
                    }
                }
            }
            sb.append(winner).append("\n");
        }
        System.out.println(sb);
    }
}