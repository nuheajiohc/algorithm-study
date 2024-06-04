import java.io.*;
import java.util.*;

public class Main {

    private static int N,M,P;
    private static int[][] board;
    private static int[] move;
    private static int[] dx = {1,0,-1,0};
    private static int[] dy = {0,1,0,-1};
    private static Queue<int[]>[] queue;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        move = new int[P+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1 ;i<=P; i++){
            move[i] = Integer.parseInt(st.nextToken());
        }

        queue = new ArrayDeque[P+1];
        for(int i=0; i<=P; i++){
            queue[i] = new ArrayDeque<>();
        }

        board = new int[N][M];
        for(int i=0; i<N; i++){
            String line = br.readLine();
            for(int j=0; j<M; j++){
                if(line.charAt(j)=='.'){
                    board[i][j] = 0;
                }else if(line.charAt(j)=='#'){
                    board[i][j] = -1;
                }else{
                    board[i][j] = line.charAt(j)-'0';
                    queue[board[i][j]].offer(new int[]{i,j});
                }
            }
        }

        while(true){
            for(int i=1; i<=P; i++){
                int playerMove = move[i];
                if(queue[i].isEmpty()) continue;
                while(playerMove-->0){
                    int queueSize=queue[i].size();
                    while(queueSize-->0){
                        int[] cur = queue[i].poll();
                        for(int dir=0; dir<4; dir++){
                            int nx = cur[0] + dx[dir];
                            int ny = cur[1] + dy[dir];
                            if(isOutOfRange(nx,ny)) continue;
                            if(board[nx][ny]!=0) continue;
                            board[nx][ny]=board[cur[0]][cur[1]];
                            queue[i].offer(new int[]{nx,ny});
                        }
                    }
                    if(queue[i].isEmpty()) break;
                }
            }

            if(isAllEmptyQueue()) break;
        }

        int[] result = new int[P+1];
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(board[i][j]<1) continue;
                result[board[i][j]]++;
            }
        }
        StringBuilder sb =new StringBuilder();
        for(int i=1; i<=P; i++){
            sb.append(result[i]).append(" ");
        }
        System.out.println(sb.toString());
    }

    public static boolean isAllEmptyQueue(){
        for(Queue<int[]> q : queue){
            if(!q.isEmpty()) return false;
        }
        return true;
    }

    public static boolean isOutOfRange(int x, int y){
        return x<0 || x>=N || y<0 || y>=M;
    }
}
