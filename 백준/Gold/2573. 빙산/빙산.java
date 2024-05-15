import java.io.*;
import java.util.*;

public class Main {

    private static int[] dx = {1,0,-1,0};
    private static int[] dy = {0,1,0,-1};
    private static int[][] iceberg, newIceberg;
    private static boolean[][] vis;
    private static int N,M,time,zeroCount;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        iceberg = new int[N][M];
        newIceberg = new int[N][M];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                iceberg[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while(true){
            time++;
            meltIceberg();
            if(zeroCount==N*M){
                time=0;
                break;
            }
            if(isSplit()){
                break;
            }
            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    iceberg[i][j] = newIceberg[i][j];
                }
            }
        }
        System.out.println(time);
    }

    public static boolean isSplit(){
        int count=0;
        vis = new boolean[N][M];
        zeroCount=0;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(newIceberg[i][j]==0){
                    zeroCount++;
                }
                if(newIceberg[i][j]==0 || vis[i][j]) continue;
                vis[i][j]=true;
                count++;
                if(count>1){
                    return true;
                }
                Queue<int[]> queue = new ArrayDeque<>();
                queue.offer(new int[]{i,j});
                while(!queue.isEmpty()){
                    int[] cur = queue.poll();
                    for(int dir=0; dir<4; dir++){
                        int nx = cur[0] + dx[dir];
                        int ny = cur[1] + dy[dir];
                        if(nx<0 || nx>=N || ny<0 || ny>=M) continue;
                        if(vis[nx][ny] || newIceberg[nx][ny]==0) continue;
                        queue.offer(new int[]{nx,ny});
                        vis[nx][ny] = true;
                    }
                }
            }
        }
        return false;
    }

    public static void meltIceberg(){
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(iceberg[i][j]>0){
                    int count=0;
                    for(int dir=0; dir<4; dir++){
                        int nx = i+dx[dir];
                        int ny = j+dy[dir];
                        if(nx<0 || nx>=N || ny<0 || ny>=M) continue;
                        if(iceberg[nx][ny]>0) continue;
                        count++;
                    }
                    newIceberg[i][j] = Math.max(iceberg[i][j]-count,0);
                }
            }
        }
    }
    
}
