import java.io.*;
import java.util.*;

public class Main {

    private static int H,W;
    private static char[][] grid;
    private static boolean[][] vis;
    private static int[] dx = {0,1,0,-1};
    private static int[] dy = {1,0,-1,0};
    private static String[] sign = {">","v","<","^"};
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        vis = new boolean[H+1][W+1];
        grid = new char[H+1][W+1];
        for(int i=1; i<=H; i++){
            String str = br.readLine();
            for(int j=1; j<=W; j++){
                grid[i][j] = str.charAt(j-1);
            }
        }

        Point sp = findStartPoint();
        Deque<Point> queue = new ArrayDeque<>();
        queue.offer(sp);
        vis[sp.x][sp.y] = true;
        while(!queue.isEmpty()){
            Point cur = queue.poll();
            for(int dir=0; dir<4; dir++){
                int nx = cur.x+dx[dir]*2;
                int ny = cur.y+dy[dir]*2;
                if(isOutOfRange(nx,ny)) continue;
                if(vis[nx][ny] || vis[cur.x+dx[dir]][cur.y+dy[dir]]) continue;
                if(grid[nx][ny]=='.' || grid[cur.x+dx[dir]][cur.y+dy[dir]]=='.') continue;
                if(cur.dir==dir){
                    sb.append("A");
                }else{
                    if((cur.dir+1)%4==dir){
                        sb.append("R").append("A");
                    }else{
                        sb.append("L").append("A");                    
                    }
                }
                vis[cur.x+dx[dir]][cur.y+dy[dir]]=true;
                vis[nx][ny]=true;
                queue.offer(new Point(nx,ny,dir));
            }
        }
        System.out.println(sb);
    }

    public static boolean isOutOfRange(int x, int y){
        return x<1 || x>H || y<1 || y>W;
    }

    public static boolean isStartPoint(int x, int y){
        int count=0;
        for(int dir=0; dir<4; dir++){
            int nx = x+dx[dir];
            int ny = y+dy[dir];
            if(isOutOfRange(nx,ny) || grid[nx][ny]=='.'){
                count++;
            }
        }
        return count==3;
    }

    public static Point findStartPoint(){
        for(int i=1; i<=H; i++){
            for(int j=1; j<=W; j++){
                if(grid[i][j]=='#' && isStartPoint(i,j)){
                    sb.append(i+" "+j).append("\n");
                    for(int dir=0; dir<4; dir++){
                        int nx = i+dx[dir];
                        int ny = j+dy[dir];
                        if(isOutOfRange(nx,ny))continue;
                        if(grid[nx][ny]=='#'){
                            sb.append(sign[dir]).append("\n");
                            return new Point(i,j,dir);
                        }
                    }
                }
            }
        }
        return null;
    }

    public static class Point{
        int x;
        int y;
        int dir;
    
        Point(int x, int y, int dir){
            this.x=x;
            this.y=y;
            this.dir=dir;
        }
    }
}