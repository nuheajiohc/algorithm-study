import java.io.*;
import java.util.*;

public class Main {

    private static int[][] d = {{2,1},{2,-1},{1,2},{1,-2},{-1,-2},{-2,-1},{-2,1},{-1,2}};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());
        StringBuilder sb= new StringBuilder();
        for(int i=0; i<testcase; i++){
            int I = Integer.parseInt(br.readLine());
            int[][] board = new int[I][I];
            for(int j=0; j<I; j++){
                Arrays.fill(board[j], -1);
            }

            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] cur = new int[2];
            cur[0] = Integer.parseInt(st.nextToken());
            cur[1] = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int[] des = new int[2];
            des[0] = Integer.parseInt(st.nextToken());
            des[1] = Integer.parseInt(st.nextToken());


            if(Arrays.equals(cur,des)){
                sb.append(0).append("\n");
                continue;
            }

            board[cur[0]][cur[1]]=0;

            Deque<int[]> q = new ArrayDeque<>();
            q.offer(new int[]{cur[0],cur[1]});
            int move=0;
            while(!q.isEmpty()){
                int[] tempCur=q.poll();
                for(int[] dir : d){
                    int nx = tempCur[0]+dir[0];
                    int ny = tempCur[1]+dir[1];
                    if(nx<0 || nx>=I || ny<0 || ny>=I) continue;
                    if(board[nx][ny]==-1){
                        board[nx][ny] = board[tempCur[0]][tempCur[1]]+1;
                        move = board[nx][ny];
                        q.offer(new int[]{nx,ny});
                        
                        if(Arrays.equals(des,new int[]{nx,ny})){
                            sb.append(move).append("\n");
                            q.clear();
                            break;
                        }
                    }
                }
            }
        }
        System.out.println(sb.toString());
    }
}
