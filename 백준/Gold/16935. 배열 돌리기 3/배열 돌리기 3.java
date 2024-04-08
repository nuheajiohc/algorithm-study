import java.io.*;
import java.util.*;

public class Main {
    private static int N,M,R;
    private static int[][] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(st.hasMoreTokens()){
            int command = Integer.parseInt(st.nextToken());
            switch(command){
                case 1:
                    rotateX();
                    break;
                case 2:
                    rotateY();
                    break;
                case 3:
                    rotate90();
                    break;
                case 4:
                    rotateM90();
                    break;
                case 5:
                    rotate5();
                    break;
                case 6:
                    rotate6();
                break;
            }
        }
        for(int i=0; i<N; i++){
            for(int j=0; j<M;j++){
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    public static void rotateX(){
        for(int i=0; i<N/2; i++){
            for(int j=0; j<M; j++){
                int temp = arr[i][j];
                arr[i][j] = arr[N-i-1][j];
                arr[N-i-1][j] = temp;
            }
        }
    }

    public static void rotateY(){
        for(int j=0; j<M/2; j++){
            for(int i=0; i<N; i++){
                int temp = arr[i][j];
                arr[i][j] = arr[i][M-j-1];
                arr[i][M-j-1] = temp;
            }
        }
    }

    public static void rotate90(){
        int[][] temp = new int[M][N];
        for(int j=0; j<M;j++){
            for(int i=N-1; i>=0; i--){
                temp[j][N-i-1] = arr[i][j];
            }
        }
        N = arr[0].length;
        M = arr.length;
        arr = temp;
    }

    public static void rotateM90(){
        int[][] temp = new int[M][N];
        for(int j=M-1; j>=0; j--){
            for(int i=0;i<N; i++){
                temp[M-1-j][i]=arr[i][j];
            }
        }
        N = arr[0].length;
        M = arr.length;
        arr = temp;
    }

    public static void rotate5(){
        for(int i=0; i<N/2; i++){
            for (int j=0; j<M/2; j++){
                int temp = arr[i][j];
                arr[i][j] = arr[i+N/2][j];
                arr[i+N/2][j] = arr[i+N/2][j+M/2];
                arr[i+N/2][j+M/2] = arr[i][j+M/2];
                arr[i][j+M/2] = temp;
            }
        }
    }

    public static void rotate6(){
        for(int i=0; i<N/2; i++){
            for(int j=0; j<M/2; j++){
                int temp = arr[i][j];
                arr[i][j] = arr[i][j+M/2];
                arr[i][j+M/2] = arr[i+N/2][j+M/2];
                arr[i+N/2][j+M/2] = arr[i+N/2][j];
                arr[i+N/2][j] = temp;
            }
        }
    }
}
