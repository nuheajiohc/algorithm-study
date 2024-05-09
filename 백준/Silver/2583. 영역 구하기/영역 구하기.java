import java.io.*;
import java.util.*;

public class Main {

    private static int[] dx = {1,0,-1,0};
    private static int[] dy = {0,1,0,-1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        boolean[][] paper = new boolean[M][N];
        while(K-->0){
            st= new StringTokenizer(br.readLine());
            int y1 = Integer.parseInt(st.nextToken());
            int x1 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            for(int i=x1; i<x2; i++){
                for(int j=y1; j<y2; j++){
                    paper[i][j]=true;
                }
            }
        }

        int count=0;
        List<Integer> sizeList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M; i++){
            for(int j=0; j<N; j++){
                if(paper[i][j]) continue;
                count++;
                Queue<int[]> queue = new ArrayDeque<>();
                queue.offer(new int[]{i,j});
                paper[i][j]=true;
                int tempSize=1;
                while(!queue.isEmpty()){
                    int[] cur = queue.poll();
                    for(int dir=0; dir<4; dir++){
                        int nx = cur[0]+dx[dir];
                        int ny = cur[1]+dy[dir];
                        if(nx<0 || nx>=M || ny<0 || ny>=N) continue;
                        if(paper[nx][ny]) continue;
                        queue.offer(new int[]{nx,ny});
                        paper[nx][ny]=true;
                        tempSize++;
                    }
                }
                sizeList.add(tempSize);
            }
        }
        sb.append(count).append("\n");
        Collections.sort(sizeList);
        for(int i=0; i<count; i++){
            sb.append(sizeList.get(i)).append(" ");
        }
        System.out.println(sb.toString());
    }
}
