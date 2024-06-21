import java.io.*;
import java.util.*;

public class Main {

    private static int N;
    private static int[][] board;
    private static boolean[] xydVis;
    private static boolean[] xyuVis;

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

        xydVis = new boolean[2*N-1];
        xyuVis = new boolean[2*N-1];
        System.out.println(backtracking(0,0,0)+backtracking(0,1,0));
    }

    public static int backtracking(int x, int y, int tempCount){
            if(y>=N){
                x+=1;
                y = (y%2==0)?1:0;
            }
            if(x==N){
                return tempCount;
            }

            int maxCount = tempCount;

            if(!(xydVis[x-y+N-1] || xyuVis[x+y] || board[x][y]==0)){
                xydVis[x-y+N-1]=true;
                xyuVis[x+y]=true;
                maxCount = Math.max(maxCount,backtracking(x,y+2,tempCount+1));
                xydVis[x-y+N-1]=false;
                xyuVis[x+y]=false;
            }
            maxCount = Math.max(maxCount,backtracking(x,y+2,tempCount));
            return maxCount;
    }
}