import java.io.*;
import java.util.*;

public class Main {

    static int N, M, D;
    static int[][] map, copyMap;
    static boolean[] used;
    static int maxKilled=0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        copyMap = new int[N][M];
        used = new boolean[M];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        btk(0, 0);
        System.out.println(maxKilled);
    }

    static void btk(int depth, int k){
        if(depth==3){
            initMap();
            playGame();
            return;
        }

        for(int i=k; i<M; i++){
            used[i] = true;
            btk(depth+1, i+1);
            used[i] = false;
        }
    }

    static void initMap(){
        for(int i=0; i<N; i++){
            copyMap[i] = map[i].clone();
        }
    }

    static void playGame(){
        int killed = 0;
        while(true){
            killed += killEnemy();
            int cnt = moveEnemy();
            if(cnt==0) break;
        }

        maxKilled = Math.max(maxKilled, killed);
    }

    static int killEnemy(){
        for(int m=0; m<M; m++){
            if(!used[m]) continue;
            if(copyMap[N-1][m]>0) {
                copyMap[N-1][m]++;
                continue;
            }
            
            int x = -1;
            int y = -1;
            int d = Integer.MAX_VALUE;
            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    if(copyMap[i][j]==0) continue;
                    int dist = Math.abs(N-i) + Math.abs(m-j);
                    if(dist>D) continue;
                    if(dist<d || (dist==d && j<y)){
                        d = dist;
                        x = i;
                        y = j;
                    }
                }
            }
            if(x==-1) continue;
            copyMap[x][y]++;
        }

        int cnt = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(copyMap[i][j]>1){
                    copyMap[i][j] = 0;
                    cnt++;
                }
            }
        }
        return cnt;
    }

    static int moveEnemy(){
        int cnt = 0;
        for(int i=N-1; i>0; i--){
            for(int j=0; j<M; j++){
                copyMap[i][j] = copyMap[i-1][j];
                if(copyMap[i][j]==1) cnt++;
            }
        }
        Arrays.fill(copyMap[0], 0);
        return cnt;
    }
}
