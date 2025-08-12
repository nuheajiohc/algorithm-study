import java.io.*;
import java.util.*;

public class Main {

    private static int N,M;
    private static int[][] board;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        for(int i=0; i<N; i++){
            String line = br.readLine();
            for(int j=0; j<M; j++){
                board[i][j] = line.charAt(j)-'0';
            }
        }
        
        int max = -1;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                for(int id=-N; id<N; id++){
                    for(int jd=-M; jd<M; jd++){
                        if(id==0 && jd==0) continue;
                        int value = board[i][j];
                        int curX = i;
                        int curY = j;
                        if(value== (int)Math.sqrt(value) * (int)Math.sqrt(value)){
                            max = Math.max(max, value);
                        }
                        while(true){
                            curX+=id;
                            curY+=jd;
                            if(curX<0 || curY<0 || curX>=N || curY>=M) break;
                            value = 10*value + board[curX][curY];
                            if(value== (int)Math.sqrt(value) * (int)Math.sqrt(value)){
                                max = Math.max(max, value);
                            }
                        }
                    }
                }
            }
        }
        System.out.println(max);
    }

}
