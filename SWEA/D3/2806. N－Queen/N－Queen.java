import java.io.*;

public class Solution {

    static int N, cnt;
    static boolean[] xUsed, yUsed, descUsed, ascUsed;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int tc=1; tc<=TC; tc++){
            N = Integer.parseInt(br.readLine());
            xUsed = new boolean[N];
            yUsed = new boolean[N];
            descUsed = new boolean[2*N-1];
            ascUsed = new boolean[2*N-1];

            cnt = 0;
            combination(0);

            sb.append("#").append(tc).append(" ").append(cnt).append("\n");
        }
        System.out.println(sb);
    }

    static void combination(int x){
        if(x==N){
            cnt++;
            return;
        }

        for(int j=0; j<N; j++){
            if(!xUsed[x] && !yUsed[j] && !descUsed[x-j+N-1] && !ascUsed[x+j]){
                xUsed[x] = true;
                yUsed[j] = true;
                descUsed[x-j+N-1] = true;
                ascUsed[x+j] = true;
                combination(x+1);
                xUsed[x] = false;
                yUsed[j] = false;
                descUsed[x-j+N-1] = false;
                ascUsed[x+j] = false;
        }
        }    
    }
}
