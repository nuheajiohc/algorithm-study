import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        char[][] board = new char[H][W];
        int[][] result = new int[H][W];

        for(int i=0; i<H; i++){
            board[i] = br.readLine().toCharArray();
        }
        
        for(int i=0; i<H; i++){
            for(int j=0; j<W; j++){
                result[i][j]=-1;
            }
        }


        for(int i=0; i<H; i++){
            int start=-1;
            for(int j=0; j<W; j++){
                if(board[i][j]=='c'){
                    start=j;
                    break;
                }
            }
            if(start==-1) continue;
            for(int j=start; j<W; j++){
                if(board[i][j]=='c'){
                    result[i][j]=0;
                }else{
                    result[i][j] = result[i][j-1]+1;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<H; i++){
            for(int j=0; j<W; j++){
                sb.append(result[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
