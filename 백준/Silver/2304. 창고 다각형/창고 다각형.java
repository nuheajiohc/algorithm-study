import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Point[] points = new Point[N];
        int result=0;
        int maxIdx=0;
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            points[i] = new Point(x,y);
            if(result<y){
                result = y;
                maxIdx = x;
            }
        }
        Arrays.sort(points);
        
        int leftIdx=0;
        for(int i=0; i<N; i++){
            if(points[i].y>=points[leftIdx].y){
                result+=points[leftIdx].y*(points[i].x-points[leftIdx].x);
                leftIdx = i;
            }
            if(points[i].x==maxIdx) break;
        }
        int rightIdx=N-1;
        for(int i=N-1; i>=0; i--){
            if(points[i].y>=points[rightIdx].y){
                result += points[rightIdx].y*(points[rightIdx].x-points[i].x);
                rightIdx = i;
            }
            if(points[i].x==maxIdx) break;
        }
        System.out.println(result);
    }

    public static class Point implements Comparable<Point>{
        int x;
        int y;
        
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }

        public int compareTo(Point p){
            return x-p.x;
        }

    }
}
