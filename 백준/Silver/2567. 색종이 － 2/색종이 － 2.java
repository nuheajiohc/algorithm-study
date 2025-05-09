import java.io.*;
import java.util.*;

public class Main {

    private static int[] dx = {0,0,1,-1};
    private static int[] dy = {1,-1,0,0};
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] board= new int[102][102];
        while(N-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
        
            for(int i=x; i<x+10; i++){
                for(int j=y; j<y+10; j++){
                    board[i][j]++;
                }
            }
        }

        int count=0;
        for(int i=1; i<101; i++){
            for(int j=1; j<101; j++){
                if(board[i][j]>0){
                    for(int dir=0; dir<4; dir++){
                        int nx = i+dx[dir];
                        int ny = j+dy[dir];
                        if(board[nx][ny]==0){
                            count++;
                        }
                    }
                }
            }
        }
        System.out.println(count);

    }
}