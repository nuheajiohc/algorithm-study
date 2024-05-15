import java.io.*;
import java.util.*;

public class Main {

    private static int N,M,minDistance;
    private static int[] dx = {1,0,0,-1};
    private static int[] dy = {0,1,-1,0};
    private static int[][] street,vis;
    private static List<int[]> chickenPosition = new ArrayList<>();
    private static Deque<int[]> selectedChickenPosition = new ArrayDeque<>();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        street = new int[N][N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                street[i][j] = Integer.parseInt(st.nextToken());
                if(street[i][j]==2){
                    chickenPosition.add(new int[]{i,j});
                }
            }
        }
        minDistance = Integer.MAX_VALUE;
        backtracking(0);
        System.out.println(minDistance);
    }

    public static void backtracking(int k){
        if(selectedChickenPosition.size()==M){
            bfs();
            return;
        }

        for(int i=k; i<chickenPosition.size(); i++){
            selectedChickenPosition.offer(chickenPosition.get(i));
            backtracking(i+1);
            selectedChickenPosition.pollLast();
        }
    }

    public static void bfs(){
        vis = new int[N][N];
        for(int i=0; i<N; i++){
            Arrays.fill(vis[i],-1);
        }

        Queue<int[]> queue = new ArrayDeque<>();
        for(int[] dir: selectedChickenPosition){
            queue.offer(dir);
            vis[dir[0]][dir[1]] = 0;
        }
        int count=0;

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            for(int dir=0; dir<4; dir++){
                int nx = cur[0]+dx[dir];
                int ny = cur[1]+dy[dir];
                if(nx<0 || nx>=N || ny<0 || ny>=N) continue;
                if(vis[nx][ny]>-1) continue;
                vis[nx][ny] = vis[cur[0]][cur[1]]+1;
                if(street[nx][ny]==1){
                    count+=vis[nx][ny];
                }
                queue.offer(new int[]{nx,ny});
            }
        }
        minDistance = Math.min(minDistance, count);
    }
}
