import java.io.*;
import java.util.*;

public class Main {

    private static int[] dx = {0,0,1,-1};
    private static int[] dy = {1,-1,0,0};
    private static int N,c;

    public static void main(String[] args) throws Exception{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        c = N/5;
        String signal = br.readLine();
        int idx=0;
        char[][] encode = new char[5][c];
        for(int i=0; i<5; i++){
            for(int j=0; j<c; j++){
                encode[i][j]=signal.charAt(idx++);
            }
        }

        boolean[][] vis = new boolean[5][c];
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<c; i++){
            if(vis[0][i] || encode[0][i]=='.') continue;
            vis[0][i]=true;
            Queue<int[]> queue = new ArrayDeque<>();
            queue.offer(new int[]{0,i});
            int count=1;
            while(!queue.isEmpty()){
                int[] cur = queue.poll();
                for(int dir=0; dir<4; dir++){
                    int nx = cur[0]+dx[dir];
                    int ny = cur[1]+dy[dir];
                    if(isOutOfRange(nx,ny)) continue;
                    if(vis[nx][ny])continue;
                    if(encode[nx][ny]=='.')continue;
                    count++;
                    vis[nx][ny]=true;
                    queue.offer(new int[]{nx,ny});
                }
            }

            if(count==5){
                sb.append(1);
            }else if(count==9){
                sb.append(4);
            }else if(count==7){
                sb.append(7);
            }else if(count==13){
                sb.append(8);
            }else if(count==11){
                if(vis[3][i]){
                    sb.append(2);
                }else{
                    if(vis[1][i+2]){
                        sb.append(3);
                    }else{
                        sb.append(5);
                    }
                }
            }else{
                if(vis[2][i+1]){
                    if(vis[1][i+2]){
                        sb.append(9);
                    }else{
                        sb.append(6);
                    }
                }else{
                    sb.append(0);
                }
            }
        }
        System.out.println(sb.toString());
        
    }

    public static boolean isOutOfRange(int x ,int y){
        return x<0 || x>=5 || y<0 || y>=c;
    }
}
