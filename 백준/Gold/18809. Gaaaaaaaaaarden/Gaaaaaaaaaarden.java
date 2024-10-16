import java.io.*;
import java.util.*;

public class Main {

    private static int N,M,G,R;
    private static final int WATER=0, IMPOSSIBLE=1, POSSIBLE=2, GREEN=3, RED=4, FLOWER=10000;
    private static int[][] board;
    private static List<Point> possibleArea = new ArrayList<>();
    private static int[] used;
    private static int[] dx = {0,0,1,-1};
    private static int[] dy = {1,-1,0,0};
    private static int count=0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j] == POSSIBLE){
                    possibleArea.add(new Point(i,j));
                }
            }
        }
        
        used = new int[possibleArea.size()];

        btk(0,0,0);
        System.out.println(count);
    }

    public static void btk(int k, int g, int r){
        if(g>G || r>R) return; 
        if(g==G && r==R){
            bfs();
            return;
        }

        for(int i=k; i<possibleArea.size(); i++){
            used[i] = GREEN;
            btk(i+1,g+1,r);
            used[i] = 0;
            
            used[i] = RED;
            btk(i+1,g,r+1);
            used[i] = 0;
        }
    }

    public static void bfs(){
        int[][] vis = new int[N][M]; 
        Deque<Point> greenQueue = new ArrayDeque<>();
        Deque<Point> redQueue = new ArrayDeque<>();
        for(int i=0; i<possibleArea.size(); i++){
            int x = possibleArea.get(i).x;
            int y = possibleArea.get(i).y;
            if(used[i]==GREEN){
                vis[x][y] = 1;
                greenQueue.offer(new Point(x,y));
            }else if(used[i] == RED){
                vis[x][y] = -1;
                redQueue.offer(new Point(x,y));
            }
        }

        int temp=0;
        while(!(greenQueue.isEmpty()&& redQueue.isEmpty())){
            int gqLength = greenQueue.size();
            while(gqLength-->0){
                Point gp = greenQueue.poll();
                if(vis[gp.x][gp.y]==FLOWER) continue;
                for(int dir=0; dir<4; dir++){
                    int nx = gp.x + dx[dir];
                    int ny = gp.y + dy[dir];
                    if(isOutOfRange(nx,ny)) continue;
                    if(vis[nx][ny]>0 || vis[nx][ny]==FLOWER) continue;
                    if(board[nx][ny]==WATER) continue;
                    if(vis[nx][ny]==0) {
                        vis[nx][ny] = vis[gp.x][gp.y]+1;
                        greenQueue.offer(new Point(nx,ny));
                    }
                }
            }
        
            int rqLength = redQueue.size();
            while(rqLength-->0){
                Point rp = redQueue.poll();
                for(int dir=0; dir<4; dir++){
                    int nx = rp.x + dx[dir];
                    int ny = rp.y + dy[dir];
                    if(isOutOfRange(nx,ny)) continue;
                    if(vis[nx][ny]<0 || vis[nx][ny]==FLOWER) continue;
                    if(board[nx][ny]==WATER) continue;
                    if(vis[nx][ny]+vis[rp.x][rp.y]-1==0){
                        vis[nx][ny] = FLOWER;
                        temp++;
                    }
                    if(vis[nx][ny]==0){
                        vis[nx][ny] = vis[rp.x][rp.y]-1;
                        redQueue.offer(new Point(nx,ny));
                    }
                }
            }
        }
        count = Math.max(count, temp);
    }

    public static boolean isOutOfRange(int x, int y){
        return x<0 || y<0 || x>=N || y>=M;
    }

    public static class Point{
        int x;
        int y;

        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
