import java.io.*;
import java.util.*;

public class Main {

    static int R, C;
    static char[][] area;
    static int[][] sum;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        area = new char[R][C];

        for(int i=0; i<R; i++){
            area[i] = br.readLine().toCharArray();
        }

        sum = new int[R][C];
        for(int j=0; j<C; j++){
            if(area[0][j]=='.'){
                sum[0][j] = 1;
            }
        }

        for(int i=0; i<C; i++){
            for(int j=1; j<R; j++){
                if(area[j][i] == '.'){
                    sum[j][i] = 1 + sum[j-1][i];
                }else{
                    sum[j][i] = 0;
                }
            }
        }

        int maxPerson = 0;
        for(int i=0; i<R; i++){
            for(int j=i; j<R; j++){
                int width = 0;
                int height = j-i+1;
                for(int k=0; k<C; k++){
                    if(sum[j][k]>=height) {
                        width += 1;
                        maxPerson = Math.max(maxPerson, height*2 + width*2 - 1);
                    }else{
                        width = 0;
                    }
                }
            }
        }
        System.out.println(maxPerson);
    }
}
