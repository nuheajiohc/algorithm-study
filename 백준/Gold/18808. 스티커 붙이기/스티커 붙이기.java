import java.io.*;
import java.util.*;

public class Main {

    private static int N,M,K;
    private static int[][] background;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        background = new int[N][M];

        while(K-->0){
            st = new StringTokenizer(br.readLine());
            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            int[][] sticker = new int[R][C];
            for(int i=0; i<R; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<C; j++){
                    sticker[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            if(canCheckSticker(sticker)){
                continue;
            }
            for(int i=0; i<3; i++){
                sticker = rotateSticker(sticker);
                if(canCheckSticker(sticker)) break;
            }
        
        }
        int count=0;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(background[i][j]==1){
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    public static boolean canCheckSticker(int[][] sticker){
        int width = sticker[0].length;
        int height = sticker.length; 

        for(int i=0; i<=N-height; i++){
            for(int j=0; j<=M-width; j++){
                if(canPutSticker(sticker,i,j)){
                    putSticker(sticker,i,j);
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean canPutSticker(int[][] sticker, int x, int y){
        int width = sticker[0].length;
        int height = sticker.length; 
        for(int i=x; i<x+height; i++){
            for(int j=y; j<y+width; j++){
                if(sticker[i-x][j-y]==1 && background[i][j]==1) return false;
            }
        }
        return true;
    }

    public static void putSticker(int[][] sticker, int x, int y){
        int width = sticker[0].length;
        int height = sticker.length; 
        for(int i=x; i<x+height; i++){
            for(int j=y; j<y+width; j++){
                if(sticker[i-x][j-y]==1){
                    background[i][j]=1;
                }
            }
        }
    }

    public static int[][] rotateSticker(int[][] sticker){
        int width = sticker[0].length;
        int height = sticker.length;
        int[][] rotatedSticker = new int[width][height];

        for(int i=0; i<width; i++){
            for(int j=0; j<height; j++){
                rotatedSticker[i][j] = sticker[height-1-j][i];
            }
        }
        return rotatedSticker;
    }
}
