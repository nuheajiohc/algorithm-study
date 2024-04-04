import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] board = new int[101][101];
        int count=0;
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken())-1;
            int x = Integer.parseInt(st.nextToken())-1;
            for(int j=x+1; j<=x+10;j++){
                for(int k=y+1; k<=y+10; k++){
                    board[j][k]=1;
                }
            }
        }
        
        for(int i=1;i<101;i++){
            for(int j=1;j<101;j++){
                if(board[i][j]==1){
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}