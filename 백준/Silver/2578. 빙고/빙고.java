import java.io.*;
import java.util.*;

public class Main {

    private static int[][] board;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        board = new int[5][5];
        for(int i=0; i<5; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<5; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<Integer> q = new ArrayDeque<>();
        for(int i=0; i<5; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()){
                int n = Integer.parseInt(st.nextToken());
                q.offer(n);
            }
        }

        int count=1;
        while(!q.isEmpty()){
            int n = q.poll();
            check(n);
            if(isBingo()){
                System.out.println(count);
                break;
            }
            count++;
        }
    }

    public static void check(int target){
        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                if(board[i][j]==target){
                    board[i][j]=0;
                    return;
                } 
            }
        }
    }

    public static boolean isBingo(){
        int bingo=0;
        for(int i=0; i<5; i++){
            int count1=0;
            int count2=0;
            for(int j=0; j<5; j++){
                if(board[i][j]==0) count1++;
                if(board[j][i]==0) count2++;
            }
            if(count1==5) bingo++;
            if(count2==5) bingo++;
        }
        int count3=0;
        int count4=0;
        for(int i=0; i<5; i++){
            if(board[i][i]==0) count3++;
            if(board[i][4-i]==0) count4++;
        }
        if(count3==5) bingo++;
        if(count4==5) bingo++;
        return bingo>=3;
    }
}
