import java.io.*;
import java.util.*;

public class Main {

    private static int L,R,C;
    private static int[] dx = {1,0,-1,0,0,0};
    private static int[] dy = {0,1,0,-1,0,0};
    private static int[] dz = {0,0,0,0,1,-1};
    private static int[][][] building;
    private static BufferedReader br;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception{
        br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            
            if(L==0 && R==0 && C==0) break;

            bfs();
        }
        System.out.println(sb.toString());
    }

    public static void bfs() throws Exception{
        building = new int[L][R][C];
        Queue<int[]> queue = new ArrayDeque<>();
        int[] arrivePoint=new int[3];
        for(int z=0; z<L; z++){
            for(int x=0; x<R; x++){
                String s = br.readLine();
                for(int y=0; y<C; y++){
                    if(s.charAt(y)=='S'){
                        queue.offer(new int[]{z,x,y});
                        building[z][x][y]=1;
                    }else if(s.charAt(y)=='E'){
                        arrivePoint = new int[]{z,x,y};
                    }else if(s.charAt(y)=='#'){
                        building[z][x][y] = -1;
                    }
                }
            }
            br.readLine();
        }
        
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            for(int dir=0; dir<6; dir++){
                int nz = cur[0] + dz[dir];
                int nx = cur[1] + dx[dir];
                int ny = cur[2] + dy[dir];
                
                if(nz<0 || nz>=L || nx<0 || nx>=R || ny<0 || ny>=C) continue;
                if(building[nz][nx][ny]!=0) continue;
                building[nz][nx][ny] = building[cur[0]][cur[1]][cur[2]]+1;
                if(Arrays.equals(arrivePoint, new int[]{nz,nx,ny})){
                    sb.append("Escaped in ").append(building[nz][nx][ny]-1).append(" minute(s).").append("\n");
                    return;
                }
                queue.offer(new int[]{nz,nx,ny});
            }
        }
        
        sb.append("Trapped!").append("\n");
    }
}
