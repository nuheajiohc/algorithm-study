import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        
        int[][][] tree = new int[3][T+1][W+1];
        int jadu = Integer.parseInt(br.readLine());
        Arrays.fill(tree[jadu][1],1);
        for(int i=2; i<=T; i++){
            jadu = Integer.parseInt(br.readLine());
            tree[1][i][0] = tree[1][i-1][0]+(jadu==1?1:0);
            for(int j=1; j<=W; j++){
                if(j%2==0){
                    tree[1][i][j] = Math.max(tree[1][i-1][j],tree[2][i-1][j-1])+(jadu==1?1:0);
                }else{
                    tree[2][i][j] = Math.max(tree[1][i-1][j-1],tree[2][i-1][j])+(jadu==2?1:0);
                }
            }
        }

        int maxJadu1 = Math.max(tree[1][T][W-1],tree[1][T][W]);
        int maxJadu2 = Math.max(tree[2][T][W-1],tree[2][T][W]);
        System.out.println(Math.max(maxJadu1,maxJadu2));
    }    
}
