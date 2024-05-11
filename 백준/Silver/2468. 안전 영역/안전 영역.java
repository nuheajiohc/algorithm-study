import java.io.*;
import java.util.*;

public class Main {

    private static int[][] area;
    private static boolean[][] safeArea;
    private static int[] dx = {0,1,-1,0};
    private static int[] dy = {1,0,0,-1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        area = new int[N][N];
        int height=0;
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                area[i][j] = Integer.parseInt(st.nextToken());
                height= Math.max(height,area[i][j]);
            }
        }
        
        int maxCount=0;
        while(height>=0){
            safeArea = new boolean[N][N];
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    safeArea[i][j] = area[i][j]>height;
                }
            }

            int tempCount=0;
            for(int i=0; i<N; i++){
                for(int  j=0; j<N; j++){
                    if(!safeArea[i][j]) continue;
                    tempCount++;
                    safeArea[i][j]=false;
                    Queue<int[]> queue =new ArrayDeque<>();
                    queue.offer(new int[]{i,j});
                    while(!queue.isEmpty()){
                        int[] cur=queue.poll();
                        for(int dir=0; dir<4; dir++){
                            int nx = cur[0]+dx[dir];
                            int ny = cur[1]+dy[dir];
                            if(nx<0 || ny<0 || nx>=N || ny>=N) continue;
                            if(!safeArea[nx][ny]) continue;
                            safeArea[nx][ny] = false;
                            queue.offer(new int[]{nx,ny});
                        }
                    }
                }
            }
            maxCount = Math.max(maxCount,tempCount);
            height--;
        }
        System.out.println(maxCount);
    }
}
