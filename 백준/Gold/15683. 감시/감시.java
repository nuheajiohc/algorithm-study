import java.io.*;
import java.util.*;

public class Main {

    private static int N,M,mn;
    private static int[][] office1,office2;
    private static int[] dx = {1,0,-1,0};
    private static int[] dy = {0,1,0,-1};
    private static List<int[]> cctv = new ArrayList<>();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        office1 = new int[N][M];
        office2 = new int[N][M];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                office1[i][j] = Integer.parseInt(st.nextToken());
                if(office1[i][j]==0) mn++;
                if(office1[i][j]!=0 && office1[i][j]!=6) cctv.add(new int[]{i,j});
            }
        }

        for(int tmp=0; tmp < (1<<(2*cctv.size())); tmp++){
            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    office2[i][j] = office1[i][j];
                }
            }
            int brute = tmp;
            for(int i=0; i< cctv.size(); i++){
                int dir = brute%4;
                brute /=4;
                int x = cctv.get(i)[0];
                int y = cctv.get(i)[1];
                if(office1[x][y]==1){
                    upd(x,y,dir);
                }else if(office1[x][y]==2){
                    upd(x,y,dir);
                    upd(x,y,dir+2);
                }else if(office1[x][y]==3){
                    upd(x,y,dir);
                    upd(x,y,dir+1);
                }else if(office1[x][y]==4){
                    upd(x,y,dir);
                    upd(x,y,dir+1);
                    upd(x,y,dir+2);
                }else{
                    upd(x,y,dir);
                    upd(x,y,dir+1);
                    upd(x,y,dir+2);
                    upd(x,y,dir+3);
                }
            }
            int val=0;
            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    if(office2[i][j]==0) val++;
                }
            }
            mn = Math.min(mn,val);
        }
        System.out.println(mn);
    }

    public static void upd(int x, int y, int dir){
        dir%=4;
        while(true){
            x += dx[dir];
            y += dy[dir];
            if(x<0 || y<0 || x>=N || y>=M) return;
            if(office2[x][y]==6) return;
            if(office2[x][y]!=0) continue;
            office2[x][y]=7;
        }
    }
}
