import java.io.*;
import java.util.*;

public class Main {

    private static int[] dx = {1,0,0,-1,1,1,-1,-1};
    private static int[] dy = {0,1,-1,0,1,-1,1,-1};
    private static int N,M,K;
    private static char[][] board;
    private static Map<String,Integer> map = new HashMap<>();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        board = new char[N][M];
        for(int i=0; i<N; i++){
            board[i] = br.readLine().toCharArray();
        }

        String[] godString = new String[K];
        for(int i=0; i<K; i++){
            String line = br.readLine();
            map.put(line,0);
            godString[i] = line;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                dfs(i,j,String.valueOf(board[i][j]));
            }
        }

        for(String str : godString){
            sb.append(map.get(str)).append("\n");
        }   
        System.out.println(sb.toString());
    }

    public static void dfs(int x, int y, String s){
            if(map.containsKey(s)){
                map.put(s,map.get(s)+1);
                return;
            }

            if(s.length()>5) return;

            for(int dir=0; dir<8; dir++){
                int nx = (x + dx[dir]+N)%N;
                int ny = (y + dy[dir]+M)%M;
                dfs(nx,ny,s+String.valueOf(board[nx][ny]));
            }
        }
}
