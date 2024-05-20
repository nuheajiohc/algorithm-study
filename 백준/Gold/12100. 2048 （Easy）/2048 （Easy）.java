import java.io.*;
import java.util.*;

public class Main {

    private static int N,maxBlock;
    private static int[][] board;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        board = new int[N][N];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        backtracking(0,board);
        System.out.println(maxBlock);
    }

    public static void backtracking(int depth, int[][] board){
        if(depth == 5){
            maxBlock = Math.max(maxBlock,getMaxValue(board));
            return;
        }

        int[][] replica = getReplica(board);
        moveUp(replica);
        backtracking(depth+1, replica);
        
        replica = getReplica(board);
        moveDown(replica);
        backtracking(depth+1, replica);

        replica = getReplica(board);
        moveLeft(replica);
        backtracking(depth+1, replica);

        replica = getReplica(board);
        moveRight(replica);
        backtracking(depth+1, replica);
    }

    public static void moveUp(int[][] replica){
        Deque<Integer> queue1 = new ArrayDeque<>();
        Deque<Integer> queue2 = new ArrayDeque<>();
        for(int y=0; y<N; y++){
            for(int x=0; x<N; x++){
                if(replica[x][y]==0) continue;
                queue1.offer(replica[x][y]);
            }

            while(!queue1.isEmpty()){
                int a =queue1.poll();
                if(queue1.isEmpty()){
                    queue2.offer(a);
                    break;
                }
                int b = queue1.poll();
                if(a==b){
                    queue2.offer(a+b);
                }else{
                    queue2.offer(a);
                    queue1.offerFirst(b);
                }
            }

            for(int x=0; x<N; x++){
                if(!queue2.isEmpty()){
                    replica[x][y] = queue2.poll();
                }else{
                    replica[x][y]=0;
                }
            }
        }
    }

    public static void moveDown(int[][] replica){
        Deque<Integer> queue1 = new ArrayDeque<>();
        Deque<Integer> queue2 = new ArrayDeque<>();
        for(int y=0; y<N; y++){
            for(int x=N-1; x>=0; x--){
                if(replica[x][y]==0) continue;
                queue1.offer(replica[x][y]);
            }

            while(!queue1.isEmpty()){
                int a =queue1.poll();
                if(queue1.isEmpty()){
                    queue2.offer(a);
                    break;
                }
                int b = queue1.poll();
                if(a==b){
                    queue2.offer(a+b);
                }else{
                    queue2.offer(a);
                    queue1.offerFirst(b);
                }
            }

            for(int x=N-1; x>=0; x--){
                if(!queue2.isEmpty()){
                    replica[x][y] = queue2.poll();
                }else{
                    replica[x][y]=0;
                }
            }
        }
    }

    public static void moveLeft(int[][] replica){
        Deque<Integer> queue1 = new ArrayDeque<>();
        Deque<Integer> queue2 = new ArrayDeque<>();
        for(int x=0; x<N; x++){
            for(int y=0; y<N; y++){
                if(replica[x][y]==0) continue;
                queue1.offer(replica[x][y]);
            }

            while(!queue1.isEmpty()){
                int a =queue1.poll();
                if(queue1.isEmpty()){
                    queue2.offer(a);
                    break;
                }
                int b = queue1.poll();
                if(a==b){
                    queue2.offer(a+b);
                }else{
                    queue2.offer(a);
                    queue1.offerFirst(b);
                }
            }

            for(int y=0; y<N; y++){
                if(!queue2.isEmpty()){
                    replica[x][y]= queue2.poll();
                }else{
                    replica[x][y]=0;
                }
            }
        }
    }

    public static void moveRight(int[][] replica){
        Deque<Integer> queue1 = new ArrayDeque<>();
        Deque<Integer> queue2 = new ArrayDeque<>();
        for(int x=0; x<N; x++){
            for(int y=N-1; y>=0; y--){
                if(replica[x][y]==0) continue;
                queue1.offer(replica[x][y]);
            }

            while(!queue1.isEmpty()){
                int a =queue1.poll();
                if(queue1.isEmpty()){
                    queue2.offer(a);
                    break;
                }
                int b = queue1.poll();
                if(a==b){
                    queue2.offer(a+b);
                }else{
                    queue2.offer(a);
                    queue1.offerFirst(b);
                }
            }

            for(int y=0; y<N; y++){
                if(!queue2.isEmpty()){
                    replica[x][y]= queue2.poll();
                }else{
                    replica[x][y]=0;
                }
            }
        }
    }

    public static int getMaxValue(int[][] replica){
        int maxValue=0;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(replica[i][j]>maxValue){
                    maxValue = replica[i][j];
                }
            }
        }
        return maxValue;
    }

    public static int[][] getReplica(int[][] board){
        int[][] replica = new int[N][N];
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                replica[i][j] = board[i][j];
            }
        }
        return replica;
    }
}
