import java.io.*;
import java.util.*;

public class Main {

    private static final int NOT_VISITED = 0;
    private static final int VISITED = 1;
    private static final int IN_TEAM = 2;
    private static final int NOT_TEAM = 3;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        while(T-->0){
            int N = Integer.parseInt(br.readLine());
            int[] students = new int[N+1];
            int[] state = new int[N+1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=1; i<N+1; i++){
                students[i] = Integer.parseInt(st.nextToken());
            }

            for(int i=1; i<N+1; i++){
                if(state[i]==NOT_VISITED){
                    checkTeam(students, state,i);
                }
            }
            sb.append(countTeamMember(state)).append("\n");
        }

        System.out.println(sb.toString());
    }

    public static void checkTeam(int[] students, int[] state, int current){
        if(state[current]==NOT_VISITED){
            state[current] = VISITED;
            checkTeam(students,state,students[current]);
        }else if(state[current]==VISITED){
            state[current] = IN_TEAM;
            checkTeam(students,state,students[current]);
        }else{
            return;
        }

        if(state[current]==VISITED){
            state[current]=NOT_TEAM;
        }
    }

    public static int countTeamMember(int[] state){
        int count=0;
        for(int i=1; i<state.length; i++){
            if(state[i]==NOT_TEAM) count++;
        }
        return count;
    }
}
