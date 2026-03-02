import java.io.*;
import java.util.*;

public class Main {

    static char[][] field = new char[12][6];
    static int[] dx = {0, 0, 1, -1}, dy = {1, -1, 0, 0};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i=0; i<12; i++){
            field[i] = br.readLine().toCharArray();
        }

        int cnt = 0;
        while(true){
            boolean isBomb = bomb();
            if(!isBomb) break;
            applyGravity();
            cnt ++;
        }

        System.out.println(cnt);

    }

    static boolean bomb(){
        boolean possible = false;
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[12][6];
        for(int i=0; i<12; i++){
            for(int j=0; j<6; j++){
                if(field[i][j]=='.') continue;
                if(visited[i][j]) continue;

                char color = field[i][j];

                visited[i][j] = true;
                field[i][j] = '.';
                List<int[]> cand = new ArrayList<>();
                cand.add(new int[]{i, j});
                queue.offer(new int[]{i, j});

                while(!queue.isEmpty()) {
                    int[] cur = queue.poll();
                    int x = cur[0]; int y = cur[1];

                    for(int dir=0; dir<4; dir++){
                        int nx = x + dx[dir];
                        int ny = y + dy[dir];
                        if(nx<0 || nx>=12 || ny<0 || ny>=6) continue;
                        if(field[nx][ny]=='.' || field[nx][ny]!=color) continue;
                        visited[nx][ny] = true;
                        cand.add(new int[]{nx, ny});
                        field[nx][ny]= '.';
                        queue.offer(new int[]{nx, ny});
                    }
                }

                if(cand.size()<4){
                    for(int[] coord : cand){
                        int x = coord[0];
                        int y = coord[1];
                        field[x][y] = color;
                    }
                    continue;
                }
                possible = true;
            }
        }
        return possible;
    }

    static void applyGravity(){
        for(int j=0; j<6; j++){
            int idx = 12;
            for(int i=11; i>=0; i--){
                if(field[i][j]=='.') continue;
                char existed = field[i][j];
                field[i][j] = '.';
                field[--idx][j] = existed;
            }
        }
    }
}
