import java.io.*;
import java.util.*;

public class Solution {

    static int N, X;
    static int[][] map = new int[20][20];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int tc=1; tc<=TC; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            X = Integer.parseInt(st.nextToken());

            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int cnt = 0;
            for(int i=0; i<N; i++){
                int[] line1 = map[i];
                if(canBuild(line1)) cnt++;
                
                int[] line2 = new int[N];
                for(int j=0; j<N; j++){
                    line2[j] = map[j][i];
                }
                if(canBuild(line2)) cnt++;
            }

            sb.append("#").append(tc).append(" ").append(cnt).append("\n");
        }
        System.out.println(sb);
    }

    static boolean canBuild(int[] line){
        int cnt = 1;
        for(int i=0; i<N-1; i++){
            int diff = line[i+1] - line[i];
            if(diff == 0){
                cnt++;
            }else if(diff == 1 && cnt>=X){
                cnt=1;
            }else if(diff == -1 && cnt>=0){
                cnt = -X+1;
            }else{
                return false;
            }
        }
        return cnt>=0;
    }
}
