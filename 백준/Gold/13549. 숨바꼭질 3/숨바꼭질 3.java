import java.io.*;
import java.util.*;

public class Main {
    
    private static int[] dy = {-1,1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] position = new int[100001];
        Arrays.fill(position,-1);

        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(N);
        position[N]=0;

        while(!queue.isEmpty()){
            int cur = queue.poll();
            if(cur==K){
                System.out.println(position[K]);
                break;
            }
            int nx = cur*2;
            if(nx<=100000 && nx>=0 &&position[nx]==-1){
                position[nx] = position[cur];
                queue.offer(nx);
            }
            for(int dir: dy){
                nx = cur+dir;
                if(nx>100000 || nx<0) continue;
                if(position[nx]>-1) continue;
                position[nx] = position[cur]+1;
                queue.offer(nx);
            }
        }

    }
}
