import java.io.*;
import java.util.*;

public class Solution {

    static int N, H, W;
    static int[] dx = {0,0,1,-1}, dy = {1,-1,0,0};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int tc=1; tc<=TC; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());

            int totalBrick = 0;
            int[][] map = new int[H][W];
            for(int i=0; i<H; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<W; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if(map[i][j]>0) totalBrick++;
                }
            }

            int minCnt = btk(0, map, totalBrick);
            
            sb.append("#").append(tc).append(" ").append(minCnt).append("\n");
        }
        System.out.println(sb);
    }

    static int btk(int depth, int[][] map, int remain){
        if(remain==0) return 0;

        if(depth==N){
            return remain;
        }

        int minCnt = Integer.MAX_VALUE;
        for(int w=0; w<W; w++){
            int r = 0;
            while(r<H && map[r][w]==0) r++;
            if(r==H) continue;

            int[][] nextMap = initMap(map);
            int broken = breakBrick(nextMap, r, w);
            applyGravity(nextMap);
            minCnt = Math.min(minCnt, btk(depth+1, nextMap, remain-broken));

            if(minCnt == 0) return 0;
        }
        return minCnt;
    }

    static int[][] initMap(int[][] map){
        int[][] tmp = new int[H][W];
        for(int i=0; i<H; i++){
            for(int j=0; j<W; j++){
                tmp[i][j] = map[i][j]; 
            }
        }
        return tmp;
    }

    static int breakBrick(int[][] map, int r, int c){
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{r, c, map[r][c]});
        map[r][c] = 0;  
        int cnt = 0;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0]; int y = cur[1];
            int dist = cur[2];
            cnt++;
            for(int d=1; d<dist; d++){
                for(int dir=0; dir<4; dir++){
                    int nx = x + dx[dir]*d;
                    int ny = y + dy[dir]*d;
                    if(nx<0 || nx>=H || ny<0 || ny>=W) continue;
                    if(map[nx][ny]==0) continue;
                    q.offer(new int[]{nx, ny, map[nx][ny]});
                    map[nx][ny]=0;
                }
            }
        }
        return cnt;
    }

    static void applyGravity(int[][] map){
        for(int w=0; w<W; w++){
            int idx = H-1;
            for(int h=H-1; h>=0; h--){
                if(map[h][w]==0) continue;
                int tmp = map[h][w];
                map[h][w] = 0;
                map[idx--][w] = tmp;
            }
        }
    }
}
