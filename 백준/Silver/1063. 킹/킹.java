import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        String king = st.nextToken();
        String stone = st.nextToken();
        int N = Integer.parseInt(st.nextToken());

        int[] kingPos = new int[]{king.charAt(0)-'A'+1, king.charAt(1)-'0'};
        int[] stonePos = new int[]{stone.charAt(0)-'A'+1, stone.charAt(1)-'0'};
        
        Map<String, int[]> map = new HashMap<>();
        map.put("R",new int[]{1,0});
        map.put("L",new int[]{-1,0});
        map.put("B",new int[]{0,-1});
        map.put("T",new int[]{0,1});
        map.put("RT",new int[]{1,1});
        map.put("LT",new int[]{-1,1});
        map.put("RB",new int[]{1,-1});
        map.put("LB",new int[]{-1,-1});


        while(N-->0){
            String command = br.readLine();
            int[] pos = map.get(command);

            int kx = kingPos[0]+pos[0];
            int ky = kingPos[1]+pos[1];

            int sx = stonePos[0]+pos[0];
            int sy = stonePos[1]+pos[1];

            if(kx<=0|| kx>8 || ky<=0 || ky>8) continue;
            
            if(kx==stonePos[0] && ky==stonePos[1]){
                if(sx<=0|| sx>8 || sy<=0 || sy>8) continue;
                else{
                    stonePos[0]+=pos[0];
                    stonePos[1]+=pos[1];
                }
            }
            kingPos[0]+=pos[0];
            kingPos[1]+=pos[1];
        }

        System.out.print((char)(kingPos[0]+'A'-1));
        System.out.println(kingPos[1]);
        System.out.print((char)(stonePos[0]+'A'-1));
        System.out.println(stonePos[1]);
    }

}
