import java.io.*;
import java.util.*;

public class Main {

    private static int[][] d = {{2,1},{2,-1},{1,2},{1,-2},{-1,-2},{-2,-1},{-2,1},{-1,2}};
    private static StringBuilder sb = new StringBuilder();
    private static int[] cur,des;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());
        for(int i=0; i<testcase; i++){
            int I = Integer.parseInt(br.readLine());
            int[][] board = new int[I][I];
            for(int j=0; j<I; j++){
                Arrays.fill(board[j], -1);
            }

            StringTokenizer st = new StringTokenizer(br.readLine());
            cur = new int[2];
            cur[0] = Integer.parseInt(st.nextToken());
            cur[1] = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            des = new int[2];
            des[0] = Integer.parseInt(st.nextToken());
            des[1] = Integer.parseInt(st.nextToken());

            if(Arrays.equals(cur,des)){
                sb.append(0).append("\n");
                continue;
            }

            board[cur[0]][cur[1]]=0;
            bfs(board,I);
        }

        System.out.println(sb.toString());
    }

    public static void bfs(int[][] board, int I){
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{cur[0],cur[1],0});
        while(!q.isEmpty()){
            int[] tempCur=q.poll();
            for(int[] dir : d){
                int nx = tempCur[0]+dir[0];
                int ny = tempCur[1]+dir[1];
                if(nx<0 || nx>=I || ny<0 || ny>=I) continue;
                if(board[nx][ny]==-1){
                    board[nx][ny] = board[tempCur[0]][tempCur[1]]+1;
                    q.offer(new int[]{nx,ny,board[nx][ny]});
                    if(Arrays.equals(des,new int[]{nx,ny})){
                        sb.append(board[nx][ny]).append("\n");
                        return;
                    }
                }
            }
        }
    }
}
