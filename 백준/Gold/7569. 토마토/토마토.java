import java.io.*;
import java.util.*;

public class Main {

    private static int[][] d = {{1,0,0},{-1,0,0},{0,1,0},{0,0,1},{0,-1,0},{0,0,-1}};
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        Deque<int[]> q = new ArrayDeque<>();

        int[][][] warehouse = new int[H][N][M];
        for(int i=0; i<H; i++){
            for(int j=0; j<N; j++){
                st = new StringTokenizer(br.readLine());
                for(int k=0; k<M; k++){
                    warehouse[i][j][k] = Integer.parseInt(st.nextToken());
                    if(warehouse[i][j][k]==1){
                        q.offer(new int[]{i,j,k});
                    }
                }
            }
        }

        while(!q.isEmpty()){
            int[] cur=q.poll();
            for(int[] dir : d){
                int nz=cur[0]+dir[0];
                int nx=cur[1]+dir[1];
                int ny=cur[2]+dir[2];
                if(nz<0 || nz>=H || nx<0 || nx>=N || ny<0 || ny>=M) continue;
                if(warehouse[nz][nx][ny]!=0) continue;
                warehouse[nz][nx][ny] = warehouse[cur[0]][cur[1]][cur[2]] + 1;
                q.offer(new int[]{nz,nx,ny});
            }
        }
        int result=-1;
        for(int i=0; i<H; i++){
            for(int j=0; j<N; j++){
                for(int k=0; k<M; k++){
                    if(warehouse[i][j][k]==0){
                        System.out.println(-1);
                        return;
                    }
                    result = Math.max(result,warehouse[i][j][k]);
                }
            }
        }

        if(result==1){
            System.out.println(0);
        }else{
            System.out.println(result-1);
        }
    }
    
}
