import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    
    static int N, M;
    static int minBlind = 64;
    static int[] dx = {0, -1, 0, 1}, dy = {-1, 0, 1, 0};
    static int[][] office;
    static CCTV[] cctvs = new CCTV[8];
    static int size;
    static int[][][] modes = {
        {},
        {{0}, {1}, {2}, {3}},
        {{0, 2}, {1, 3}},
        {{0, 1}, {1, 2}, {2, 3}, {3, 0}},
        {{0, 1, 2}, {1, 2, 3}, {2, 3, 0}, {3, 0, 1}},
        {{0, 1, 2, 3}}
    };

    static int BLANK = 0, WALL = 6, WATCHED = -1, UNWATCHED = 1, CCTV_MIN = 1, CCTV_MAX = 5;

    public static void main(String[]args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        office = new int[N][M];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                office[i][j] = Integer.parseInt(st.nextToken());
                if(office[i][j]>=CCTV_MIN && office[i][j]<=CCTV_MAX){
                    cctvs[size++] = new CCTV(i, j, office[i][j]);
                }
            }
        }

        dfs(0);
        System.out.println(minBlind);
    }

    static void dfs(int depth){
        if(depth == size){
            minBlind = Math.min(minBlind, countBlind());
            return;
        }

        CCTV cctv = cctvs[depth];

        for(int[] dirs : modes[cctv.type]){
            for(int dir : dirs){
                watch(cctv.x, cctv.y, dir, WATCHED);
            }

            dfs(depth+1);
            for(int dir : dirs){
                watch(cctv.x, cctv.y, dir, UNWATCHED);
            }
        }
    }

    static int countBlind(){
        int cnt = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(office[i][j]==BLANK) cnt++;
            }
        }
        return cnt;
    }

    static void watch(int x, int y, int dir, int delta){
        int nx = x + dx[dir];
        int ny = y + dy[dir];

        if(nx<0 || nx>=N || ny<0 || ny>=M) return;
        if(office[nx][ny] == WALL) return;
        if(office[nx][ny]>=CCTV_MIN && office[nx][ny]<=CCTV_MAX){
            watch(nx, ny, dir, delta);
            return;
        }

        office[nx][ny] += delta;
        watch(nx, ny, dir, delta);
    }

    static class CCTV{
        int x;
        int y;
        int type;

        CCTV(int x, int y, int type){
            this.x = x;
            this.y = y;
            this.type = type;
        }
    }
}
