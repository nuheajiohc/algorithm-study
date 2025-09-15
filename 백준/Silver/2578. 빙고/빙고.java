import java.io.*;
import java.util.*;

public class Main {

    private static int[][] board = new int[5][5];
    private static int[] numbers = new int[25];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i=0; i<5; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<5; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<5; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<5; j++){
                numbers[i*5+j] = Integer.parseInt(st.nextToken());
            }
        }

        int count=0;
        for(int i=0; i<25; i++){
            mark(numbers[i]);
            count++;
            if(isBingo()){
                break;
            }
        }
        System.out.println(count);
        
    }

    public static void mark(int n){
        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                if(board[i][j]==n){
                    board[i][j]=-1;
                    return;
                }
            }
        }
    }

    public static boolean isBingo(){
        int total=0;
        for(int i=0; i<5; i++){
            int count=0;
            for(int j=0; j<5; j++){
                if(board[i][j]==-1){
                    count++;
                }
            }
            if(count==5){
                total++;
            }
        }

        for(int i=0; i<5; i++){
            int count=0;
            for(int j=0; j<5; j++){
                if(board[j][i]==-1){
                    count++;
                }
            }
            if(count==5){
                total++;
            }
        }

        int count=0;
        for(int i=0; i<5; i++){
            if(board[i][i]==-1){
                count++;
            }
        }
        if(count==5){
            total++;
        }

        count=0;
        for(int i=0; i<5; i++){
            if(board[i][4-i]==-1){
                count++;
            }
        }
        if(count==5){
            total++;
        }

        if(total>=3){
            return true;
        }
        return false;
    }
}
