import java.io.*;
import java.util.*;

public class Main {

    private static char[][] students = new char[25][25]; 
    private static boolean[][] used= new boolean[25][25];
    private static int count=0;
    private static int[] dx = {0,0,1,-1};
    private static int[] dy = {1,-1,0,0};
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0; i<5; i++){
            students[i] = br.readLine().toCharArray();
        }

        combination(0,0,0,0);        
        System.out.println(count);
    }

    public static void combination(int s, int y, int depth, int k){
        if(depth==7){
            if(s>y && check()){
                count++;
            }
            return;
        }

        for(int i=k; i<25; i++){
            int nx = i/5;
            int ny = i%5;
            used[nx][ny] = true;
            if(students[nx][ny]=='S'){
                s+=1;
            }else{
                y+=1;
            }
            combination(s,y,depth+1,i+1);
            used[nx][ny] = false;
            if(students[nx][ny]=='S'){
                s-=1;
            }else{
                y-=1;
            }
        }
    }

    public static boolean check(){
        boolean[][] vis =new boolean[5][5];
        int temp=1;
        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                if(!used[i][j]) continue;
                Queue<Point> q = new ArrayDeque<>();
                q.offer(new Point(i,j));
                vis[i][j]=true;

                while(!q.isEmpty()){
                    Point p =q.poll();
                    for(int dir=0; dir<4; dir++){
                        int nx = p.x + dx[dir];
                        int ny = p.y + dy[dir];
                        if(nx<0 || ny<0 || nx>=5 || ny>=5) continue;
                        if(vis[nx][ny])continue;
                        if(!used[nx][ny]) continue;
                        vis[nx][ny]=true;
                        temp++;
                        q.offer(new Point(nx,ny));
                    }
                }

                if(temp==7) return true;
                return false;
            }
        }
        return false;
    }

    public static class Point{
        int x;
        int y;

        Point(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
}
