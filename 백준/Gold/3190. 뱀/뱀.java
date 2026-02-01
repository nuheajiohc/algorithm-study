import java.io.*;
import java.util.*;

public class Main {

    private static int N, K, L;
    private static int[][] board;
    private static int SPACE = 0, SNAIL = 1, APPLE =2;
    private static Deque<int[]> snail = new ArrayDeque<>();
    private static int[] dx = {0, -1, 0, 1}, dy = {-1, 0, 1, 0};
    private static int RIGHT = 2;
    private static int result = 0;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        board = new int[N][N];
        board[0][0] = SNAIL;
        while(K-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;
            board[x][y] = APPLE;
        }
        
        L = Integer.parseInt(br.readLine());
        Deque<Direction> deque = new ArrayDeque<>();
        for(int i=0; i<L; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            deque.offerLast(new Direction(Integer.parseInt(st.nextToken()), st.nextToken()));
        }

        snail.offer(new int[]{0,0});

        boolean isOver = false; 
        int dir = RIGHT;
        while(true){
            result++;
            int[] point = snail.peekLast();
            int nx = point[0] + dx[dir];
            int ny =point[1] + dy[dir];
            if(nx<0 || ny<0 || nx>=N || ny>=N){
                isOver = true;
                break;
            }

            snail.offerLast(new int[]{nx,ny});
            if(board[nx][ny]==SPACE){
                int[] remove = snail.pollFirst();
                board[remove[0]][remove[1]] = SPACE;
            }else if(board[nx][ny]==SNAIL){
                isOver = true;
                break;
            }
            board[nx][ny]=SNAIL;

            if(isOver) break;

            if(!deque.isEmpty()){
                Direction direction =  deque.peekFirst();
                if(direction.X == result){
                    if(direction.C.equals("D")){
                        dir = (dir+1)%4;
                    }else{
                        dir = (dir+3)%4;
                    }
                    deque.pollFirst();
                } 
            }
        }

        System.out.println(result);
    }

    public static class Direction{
        int X;
        String C;

        public Direction(int X, String C){
            this.X = X;
            this.C = C;
        }
    }
}
