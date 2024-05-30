import java.io.*;
import java.util.*;

public class Main {

    private static int N;
    private static int[][] paper;
    private static Map<Integer,Integer> map = new HashMap<>();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        paper = new int[N][N];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        map.put(-1,0);
        map.put(0,0);
        map.put(1,0);

        recursion(0, 0, N);

        StringBuilder sb = new StringBuilder();
        sb.append(map.get(-1)).append("\n");
        sb.append(map.get(0)).append("\n");
        sb.append(map.get(1)).append("\n");
        System.out.println(sb.toString());
    }

    public static void recursion(int x, int y, int l){
        if(isSame(x,y,l)){
            map.put(paper[x][y], map.get(paper[x][y])+1);
            return;
        }

        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                recursion(x+(i*l/3), y+(j*l/3), l/3);
            }
        }
    }

    public static boolean isSame(int x, int y, int l){
        for(int i=x; i<x+l; i++){
            for(int j=y; j<y+l; j++){
                if(paper[i][j]!=paper[x][y]) return false;
            }
        }
        return true;
    }
}
