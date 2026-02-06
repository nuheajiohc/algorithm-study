import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[][] office;
    static int[] dx = {0, -1, 0, 1}, dy = {-1, 0, 1, 0};
    static CCTV[] cctv = new CCTV[8];
    static int[] direction = new int[8];
    static int size;
    static int min = 64;
    static int SEE = 7;
    static int BLANK = 0;
    
    public static void main(String[]args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        office = new int[N][M];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                office[i][j] = Integer.parseInt(st.nextToken());
                if(office[i][j]>0 && office[i][j]<6){
                    cctv[size++] = new CCTV(i, j, office[i][j]);
                }
            }
        }

        permutation(0);

        System.out.println(min);
    }

    static void calMin(){
        int tmp = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(office[i][j]==0){
                    tmp++;
                }
            }
        }
        min = Math.min(min, tmp);
    }

    static void watch(){

        for(int i=0; i<size; i++){
            int type = cctv[i].type;
            int dir = direction[i];
            int nx = cctv[i].x;
            int ny = cctv[i].y;

            if(type == 1){
                go(nx, ny, dir, SEE);
            }else if(type == 2){
                go(nx, ny, dir, SEE);
                go(nx, ny, (dir+2)%4, SEE);
            }else if(type == 3){
                go(nx, ny, dir, SEE);
                go(nx, ny, (dir+1)%4, SEE);
            }else if(type == 4){
                go(nx, ny, dir, SEE);
                go(nx, ny, (dir+1)%4, SEE);
                go(nx, ny, (dir+2)%4, SEE);
            }else{
                go(nx, ny, dir, SEE);
                go(nx, ny, (dir+1)%4, SEE);
                go(nx, ny, (dir+2)%4, SEE);
                go(nx, ny, (dir+3)%4, SEE);
            }
        }

        calMin();

        for(int i=0; i<size; i++){
            int type = cctv[i].type;
            int dir = direction[i];
            int nx = cctv[i].x;
            int ny = cctv[i].y;

            if(type == 1){
                go(nx, ny, dir, BLANK);
            }else if(type == 2){
                go(nx, ny, dir, BLANK);
                go(nx, ny, (dir+2)%4, BLANK);
            }else if(type == 3){
                go(nx, ny, dir, BLANK);
                go(nx, ny, (dir+1)%4, BLANK);
            }else if(type == 4){
                go(nx, ny, dir, BLANK);
                go(nx, ny, (dir+1)%4, BLANK);
                go(nx, ny, (dir+2)%4, BLANK);
            }else{
                go(nx, ny, dir, BLANK);
                go(nx, ny, (dir+1)%4, BLANK);
                go(nx, ny, (dir+2)%4, BLANK);
                go(nx, ny, (dir+3)%4, BLANK);
            }
        }
    }

    static void go(int nx, int ny, int dir, int target){
        while(true){
            nx += dx[dir];
            ny += dy[dir];
            if(nx<0 || nx>=N || ny<0 || ny>=M) return;
            if(office[nx][ny]==6) return;
            if(office[nx][ny]>0 && office[nx][ny]<6) continue;
            office[nx][ny] = target;
        }
    }

    static void permutation(int depth){
        if(depth==size){
            watch();
            return;
        }


        for(int i=0; i<4; i++){
            direction[depth] = i;
            permutation(depth+1);
        }
    }
    

    static class CCTV{
        int x;
        int y;
        int type;

        CCTV(int x, int y, int type){
            this.x = x;
            this.y = y;
            this.type = type;
        }
    }
}
