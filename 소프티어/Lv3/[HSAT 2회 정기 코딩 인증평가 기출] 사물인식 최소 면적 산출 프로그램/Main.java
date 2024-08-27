import java.io.*;
import java.util.*;

public class Main {

    private static int N,K;
    private static List<Point>[] colorPoint;
    private static int minX,minY,maxX,maxY;
    private static int minArea = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        colorPoint = new ArrayList[K+1];
        for(int i=1; i<=K; i++){
            colorPoint[i] = new ArrayList<>();
        }

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            colorPoint[k].add(new Point(x,y));
        }

        minX = minY = 1001;
        maxX = maxY = -1001;
        dfs(1);
        System.out.println(minArea);
    }

    public static void dfs(int color){
        if(color==K+1){
            int area = (maxX-minX)*(maxY-minY);
            minArea = Math.min(minArea, area);
            return;
        }

        for(Point p : colorPoint[color]){
            int prevMinX = minX;
            int prevMaxX = maxX;
            int prevMinY = minY;
            int prevMaxY = maxY;

            minX = Math.min(minX,p.x);
            minY = Math.min(minY,p.y);
            maxX = Math.max(maxX,p.x);
            maxY = Math.max(maxY,p.y);
            int area = (maxX-minX)*(maxY-minY);
            if(minArea > area){
                dfs(color+1);
            }

            minX = prevMinX;
            minY = prevMinY;
            maxX = prevMaxX;
            maxY = prevMaxY;
        }
    }

    public static class Point{
        int x;
        int y;

        public Point(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
}
