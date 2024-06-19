import java.io.*;
import java.util.*;

public class Main {

    private static int N,M,G,R;
    private static int FLOWER =3;
    private static int RED = 2;
    private static int GREEN = 1;
    private static int NO =0;
    private static int[][] land;
    private static int[] dx = {0,0,1,-1};
    private static int[] dy = {1,-1,0,0};
    private static List<int[]> possibleSpace= new ArrayList<>();
    private static int[] isUsed;
    private static int maxFlower=0;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        land = new int[N][M];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                land[i][j] = Integer.parseInt(st.nextToken());
                if(land[i][j]==2) possibleSpace.add(new int[]{i,j});
            }
        }
        isUsed = new int[possibleSpace.size()];
        selectG(0,0);
        System.out.println(maxFlower);
    }

    public static void selectG(int GDepth, int k){
        if(GDepth == G){
            selectR(0,0);
            return;
        }
        for(int i=k; i<possibleSpace.size(); i++){
            isUsed[i] = GREEN;
            selectG(GDepth+1, i+1);
            isUsed[i] = NO;
        }
    }

    public static void selectR(int RDepth, int k){
        if(RDepth == R){
            maxFlower = Math.max(maxFlower,bfs());
            return;
        }
        for(int i=k; i<possibleSpace.size(); i++){
            if(isUsed[i]==GREEN) continue;
            isUsed[i] = RED;
            selectR(RDepth+1, i+1);
            isUsed[i] = NO;
        }
    }

    public static int bfs(){
        int[][] vis = new int[N][M];
        int[][] state = new int[N][M];
        Queue<Seed> queue = new ArrayDeque<>();
        for(int i=0; i<isUsed.length; i++){
            if(isUsed[i]==NO) continue;
            int[] cur = possibleSpace.get(i);
            queue.offer(new Seed(isUsed[i],cur[0],cur[1]));
            state[cur[0]][cur[1]] = isUsed[i];
            vis[cur[0]][cur[1]] = 1;
        }
        int flowerCount=0;
        while(!queue.isEmpty()){
            int curSize = queue.size();
            while(curSize-->0){
                Seed cur = queue.poll();
                for(int dir=0; dir<4; dir++){
                    int nx = cur.x+dx[dir];
                    int ny = cur.y+dy[dir];
                    if(isOutOfRange(nx,ny)) continue;
                    if(land[nx][ny]==0) continue;
                    if(vis[nx][ny]==0){
                        vis[nx][ny] = vis[cur.x][cur.y]+1;
                        state[nx][ny] = cur.color;
                        queue.offer(new Seed(cur.color,nx,ny));
                    } else if((vis[nx][ny]==vis[cur.x][cur.y]+1) && (cur.color!= state[nx][ny]) && (state[nx][ny]!=FLOWER)){
                        state[nx][ny]=FLOWER;
                        vis[nx][ny] = vis[cur.x][cur.y]+1;
                        flowerCount++;
                    }
                }
            }
            curSize = queue.size();
            while(curSize-->0){
                Seed seed = queue.poll();
                if(state[seed.x][seed.y]==FLOWER) continue;
                queue.offer(seed);
            }
        }
        return flowerCount;

    }

    public static boolean isOutOfRange(int x, int y){
        return x<0 || x>=N || y<0 || y>=M;
    }

    public static class Seed{
        int color;
        int x;
        int y;

        Seed(int color, int x, int y){
            this.color = color;
            this.x = x;
            this.y = y;
        }
    }
}
