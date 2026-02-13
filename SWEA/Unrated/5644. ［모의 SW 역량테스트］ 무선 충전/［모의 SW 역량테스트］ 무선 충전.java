import java.io.*;
import java.util.*;

public class Solution {

    static int M,A;
    static Battery[] batteries;
    static int[] moveA, moveB;
    static int Ax, Ay, Bx, By;
    static int[] dx = {0, 0, 1, 0, -1}, dy = {0, -1, 0, 1, 0};
    static int max;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int tc=1; tc<=TC; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            A = Integer.parseInt(st.nextToken());

            Ax=1; Ay=1; Bx=10; By=10;
            max = 0;

            moveA = new int[M];
            moveB = new int[M];
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<M; i++){
                moveA[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<M; i++){
                moveB[i] = Integer.parseInt(st.nextToken());
            }

            batteries = new Battery[A];
            for(int i=0; i<A; i++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int C = Integer.parseInt(st.nextToken());
                int P = Integer.parseInt(st.nextToken());
                batteries[i] = new Battery(x, y, C, P);
            }
            
            charge();
            for(int m=0; m<M; m++){
                Ax += dx[moveA[m]];
                Ay += dy[moveA[m]];
                Bx += dx[moveB[m]];
                By += dy[moveB[m]];
                charge();
            }
            sb.append("#").append(tc).append(" ").append(max).append("\n");
        }

        System.out.println(sb);
    }

    static void charge(){
        int sum = 0;
        for(int i=0; i<A; i++){
            for(int j=0; j<A; j++){
                boolean aPossible = canCharge(Ax, Ay, i);
                boolean bPossible = canCharge(Bx, By, j);
                if(aPossible && bPossible){
                    if(i==j){
                        sum = Math.max(sum, batteries[i].P);
                    }else{
                        sum = Math.max(sum, batteries[i].P + batteries[j].P);
                    }
                }else if(aPossible && !bPossible){
                    sum = Math.max(sum, batteries[i].P);
                }else if(!aPossible && bPossible){
                    sum = Math.max(sum, batteries[j].P);
                }
            }
        }
        max += sum;
    }

    static boolean canCharge(int x, int y, int idx){
        int dist = Math.abs(x-batteries[idx].x) + Math.abs(y-batteries[idx].y);
        return dist<=batteries[idx].C;
    }

    static class Battery{
        int x; int y;
        int C; int P;

        Battery(int x, int y, int C, int P){
            this.x = x;
            this.y = y;
            this.C = C;
            this.P = P;
        }
    }
}
