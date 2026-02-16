import java.io.*;
import java.util.*;

public class Solution {

    static int N,H,W;
    static int[][] map, copyMap;
    static int[] dx = {0,0,1,-1}, dy = {1,-1,0,0};
    static int[] tmp, used;
    static int minCnt;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int tc=1; tc<=TC; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
            map = new int[H][W];
            copyMap = new int[H][W];
            used = new int[N];
            tmp = new int[H];
            minCnt = Integer.MAX_VALUE;
            for(int i=0; i<H; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<W; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            btk(0);
            
            sb.append("#").append(tc).append(" ").append(minCnt).append("\n");
        }
        System.out.println(sb);
    }

    static void btk(int depth){
        if(depth==N){
            initMap();
            for(int i=0; i<N; i++){
                breakBrick(used[i]);
                afterProcess();
            }
            countBrick();
            return;
        }

        for(int w=0; w<W; w++){
            used[depth] = w;
            btk(depth+1);
        }
    }

    static void initMap(){
        for(int i=0; i<H; i++){
            for(int j=0; j<W; j++){
                copyMap[i][j] = map[i][j]; 
            }
        }
    }

    static void countBrick(){
        int cnt = 0;
        for(int i=0; i<H; i++){
            for(int j=0; j<W; j++){
                if(copyMap[i][j]>0) cnt++;
            }
        }
        minCnt = Math.min(minCnt, cnt);
    }

    static void breakBrick(int w){
        Queue<int[]> q = new ArrayDeque<>();
        for(int h=0; h<H; h++){
            if(copyMap[h][w]>0){
                q.offer(new int[]{h,w});
                break;
            }
        }

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0]; int y = cur[1];
            int dist = copyMap[x][y];
            copyMap[x][y]=0;
            for(int d=1; d<dist; d++){
                for(int dir=0; dir<4; dir++){
                    int nx = x + dx[dir]*d;
                    int ny = y + dy[dir]*d;
                    if(nx<0 || nx>=H || ny<0 || ny>=W) continue;
                    if(copyMap[nx][ny]==0) continue;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
    }

    static void afterProcess(){
        for(int w=0; w<W; w++){
            Arrays.fill(tmp, 0);
            int idx = 0;
            for(int h=H-1; h>=0; h--){
                if(copyMap[h][w]>0) tmp[idx++] = copyMap[h][w];
            }
            for(int h=H-1; h>=0; h--){
                copyMap[h][w] = tmp[H-h-1];
            }
        }
    }
}
