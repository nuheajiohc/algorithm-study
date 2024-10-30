import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(T-->0){
            int N = Integer.parseInt(br.readLine());
            Person[] person = new Person[N];
            for(int i=0; i<N; i++){
                person[i] = new Person();
            }
            int[] num = new int[201];
            StringTokenizer st  = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                int k = Integer.parseInt(st.nextToken());
                person[i].team = k;
                num[k]++;
            }
            
            Team[] team = new Team[201];
            for(int i=0; i<201; i++){
                team[i] = new Team(i);
            }
            int count=1;
            for(int i=0; i<N; i++){
                if(num[person[i].team]>=6){
                    person[i].score = count;
                    count++;
                    team[person[i].team].add(person[i].score);
                }        
            }
            
            Arrays.sort(team);
            sb.append(team[0].num).append("\n");
        }
        System.out.println(sb);
    }

    public static class Person{
        int team;
        int score;

    }

    public static class Team implements Comparable<Team>{
        int num;
        List<Integer> members = new ArrayList<>();

        Team(int num){
            this.num = num;
        }

        public void add(int member){
            members.add(member);
        }

        public int getTop4Score(){
            int sum=0;
            if(members.size()<6){
                return 10000;
            }
            for(int i=0; i<4; i++){
                sum+=members.get(i);
            }
            return sum;
        }

        public int get5thScore(){
            if(members.size()<6){
                return 10000;
            }
            return members.get(4);
        }

        public int compareTo(Team t){
            if(getTop4Score()==t.getTop4Score()){
                return get5thScore()-t.get5thScore();
            }
            return getTop4Score()-t.getTop4Score();
        }
    }
}
