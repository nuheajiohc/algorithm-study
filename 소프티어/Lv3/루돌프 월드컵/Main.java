import java.io.*;
import java.util.*;

public class Main {

    private static int[][] board = new int[4][4];
    private static double[] deers = new double[4]; 
    private static final int WIN = 1;
    private static final int DRAW = 0;
    private static final int LOSE = -1;
    private static double result;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<4; i++){
            deers[i] = Double.parseDouble(st.nextToken());
        }

        check(0,1);
        System.out.println(String.format("%.3f",result*100));
    }

    public static void check(int x, int y){
        if(y>=4){
            x+=1;
            y=x+1;
        }
        if(x==3){
            double[] temp = new double[4];
            for(int i=0; i<4; i++){
                for(int j=0; j<4; j++){
                    if(i==j) continue;
                    if(board[i][j]==WIN) temp[i]+=3;
                    else if(board[i][j]==DRAW) temp[i]+=1;
                }
            }
            int count=4;
            for(int i=1; i<4; i++){
                if(temp[0]>=temp[i])count--;
            }
            
            if(count<=2){
                double probability=1;
                for(int i=0; i<3; i++){
                    for(int j=i+1; j<4; j++){
                        if(board[i][j]==WIN){
                            probability*=(4*deers[i])/(5*deers[i] + 5*deers[j]);
                        }else if(board[i][j]==DRAW){
                            probability*=(deers[i]+deers[j])/(5*deers[i] + 5*deers[j]);
                        }else{
                            probability*=(4*deers[j])/(5*deers[i] + 5*deers[j]);
                        }
                    }
                }
                result+=probability;
            }
            return;
        }

        board[x][y]=WIN;
        board[y][x]=LOSE;
        check(x,y+1);
        board[x][y]=DRAW;
        board[y][x]=DRAW;
        check(x,y+1);
        board[x][y]=LOSE;
        board[y][x]=WIN;
        check(x,y+1);
    }
}
