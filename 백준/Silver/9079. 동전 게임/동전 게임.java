import java.io.*;
import java.util.*;

public class Main {

    private static int N;
    private static Queue<Integer> queue;
    private static BufferedReader br;
    private static StringTokenizer st;

    private static int[] flipCase = {7, 7 << 3, 7 << 6, 73, 73 << 1, 73 << 2, 273, 84};
    private static int[] vis;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            System.out.println(testcase());
        }
    }

    public static int testcase() throws IOException {
        vis= new int[512];
        queue = new LinkedList<>();

        int start = convertToInt();
        if(start ==0 || start == 511){
            return 0;
        }
        vis[start]=1;
        queue.offer(start);
        while(!queue.isEmpty()){
            int cur=queue.poll();
            for(int dir : flipCase){
                int nowCur=cur^dir;
                if(nowCur ==0 || nowCur == 511){
                    return vis[cur];
                }
                if(vis[nowCur]==0){
                    vis[nowCur]=vis[cur]+1;
                    queue.add(nowCur);
                }
            }
        }
        return -1;
    }

    private static int convertToInt() throws IOException {
        String str = (br.readLine() + br.readLine() + br.readLine()).replace(" ", "").replace("H", "0")
                .replace("T", "1");
        return Integer.parseInt(str, 2);
    }
}
