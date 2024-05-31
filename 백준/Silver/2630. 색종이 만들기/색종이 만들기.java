import java.io.*;
import java.util.*;

public class Main {

    private static int N;
    private static int[][] paper;
    private static int[] result = new int[2];

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
        recursion(0,0,N);
        System.out.println(result[0]+"\n"+result[1]);
    }

    public static void recursion(int x, int y, int l){
        if(isSame(x,y,l)){
            result[paper[x][y]]++;
            return;
        }

        for(int i=0; i<2; i++){
            for(int j=0; j<2; j++){
                recursion(x+(i*l/2), y+(j*l/2),l/2);
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
