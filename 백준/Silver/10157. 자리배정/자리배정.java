import java.io.*;
import java.util.*;

public class Main {

    private static int[] dx = {1,0,-1,0};
    private static int[] dy = {0,1,0,-1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        int target = Integer.parseInt(br.readLine());
        int[][] board = new int[x][y];

        int dir=0;
        int cur_x=-1;
        int cur_y=0;

        int answer_x=-1;
        int answer_y=-1;
        for(int i=1; i<=x*y; i++){
            int next_x = cur_x + dx[dir];
            int next_y = cur_y + dy[dir];
            if(next_x<0 || next_x>=x || next_y<0 || next_y>=y || board[next_x][next_y]>0){
               dir= (dir+1)%4; 
               cur_x +=dx[dir];
               cur_y +=dy[dir];
            }else{
                cur_x = next_x;
                cur_y = next_y;
            }
            board[cur_x][cur_y] = i;
            if(i==target){
                answer_x=cur_x+1;
                answer_y=cur_y+1;
                break;
            }
        }

        if(answer_x==-1){
            System.out.println(0);
        }else{
            System.out.println(answer_y+ " "+answer_x);
        }
    }
}
