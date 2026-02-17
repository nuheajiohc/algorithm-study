import java.io.*;
import java.util.*;

public class Solution {

    static int N, M, K;
    static Cell[][] grid;
    static int[] dx = {0,0,1,-1}, dy = {1,-1,0,0};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        for(int tc=1; tc<=TC; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            grid = new Cell[500][500];
            Queue<Cell> queue = new ArrayDeque<>();
            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<M; j++){
                    int life = Integer.parseInt(st.nextToken());
                    if(life == 0) continue;
                    grid[i+200][j+200] = new Cell(i+200, j+200, life);
                    if(life>0) queue.offer(grid[i+200][j+200]);
                }
            }

            Queue<int[]> temp = new ArrayDeque<>();
            while(K-->0){
                int size = queue.size();
                while(size-->0){
                    Cell cell = queue.poll();
                    if(cell.inactive>0){
                        cell.inactive--;
                        queue.offer(cell);
                    } else{
                        cell.active++;
                        if(cell.active>=cell.life) cell.dead = true;
                        else queue.offer(cell);

                        if(cell.active==1){
                            for(int dir=0; dir<4; dir++){
                                int nx = cell.x+dx[dir];
                                int ny = cell.y+dy[dir];
                                if(grid[nx][ny]!=null) continue;
                                temp.offer(new int[]{nx, ny});
                                grid[nx][ny] = new Cell(nx, ny, -1);
                            }
                        }
                    }
                }
                while(!temp.isEmpty()){
                    int[] cur = temp.poll();
                    int max = 0;
                    for(int dir=0; dir<4; dir++){
                        int nx = cur[0] + dx[dir];
                        int ny = cur[1] + dy[dir];
                        Cell cand = grid[nx][ny];
                        if(cand==null || cand.active!=1) continue;
                        if(max<cand.life){
                            max = cand.life;
                        }
                    }
                    grid[cur[0]][cur[1]].life = max;
                    grid[cur[0]][cur[1]].inactive = max;
                    queue.offer(grid[cur[0]][cur[1]]);
                }
                
            }
            sb.append("#").append(tc).append(" ").append(queue.size()).append("\n");

        }

        System.out.println(sb);
    }

    static class Cell{
        int x, y, life, inactive, active;
        boolean dead;

        Cell(int x, int y, int life){
            this.x = x;
            this.y = y;
            this.life = life;
            this.inactive= life;
        }
    }
}
