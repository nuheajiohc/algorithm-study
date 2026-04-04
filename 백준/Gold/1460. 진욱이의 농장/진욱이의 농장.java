import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[][] farm;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        farm = new int[N][N];

        while(M-->0){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            int f = Integer.parseInt(st.nextToken());

            for(int i=x; i<x+l; i++){
                for(int j=y; j<y+l; j++){
                    farm[i][j] = f;
                }
            }
        }

        Set<Integer> fruitTypes = new HashSet<>();
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(farm[i][j]>0) fruitTypes.add(farm[i][j]);
            }
        }

        if(fruitTypes.size()==0){
            System.out.println(0);
            return;
        }

        List<Integer> list = new ArrayList<>(fruitTypes);

        int max = 0;
        for(int i=0; i<list.size(); i++){
            for(int j=i; j<list.size(); j++){
                max = Math.max(max, cal(list.get(i), list.get(j)));
            }
        }
        System.out.println(max);
    }

    static int cal(int type1, int type2){
        int[][] dp = new int[N][N];

        int max = 1;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(farm[i][j]==0) continue;
                if(farm[i][j]!=type1 && farm[i][j]!=type2) continue;

                if(i==0 || j==0){
                    dp[i][j] = 1;
                }else{
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]))+1;
                }
                max = Math.max(max, dp[i][j]*dp[i][j]);
            }
        }
        return max;
    }
}
