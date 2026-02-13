import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int tc=1; tc<=TC; tc++){
            long N = Long.parseLong(br.readLine());
            int cnt = 0;
            while(N!=2){
                long target = (long)Math.sqrt(N);
                if(target*target == N){
                    N = target;
                    cnt++;
                }else{
                    cnt += (target+1)*(target+1)-N;
                    N = (target+1)*(target+1);
                }
            }
            sb.append("#").append(tc).append(" ").append(cnt).append("\n");
        }
        System.out.println(sb);
    }
}
