import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(N-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int[] aScore = new int[5];
            while(st.hasMoreTokens()){
                int score = Integer.parseInt(st.nextToken());
                aScore[score]++;
            }

            st = new StringTokenizer(br.readLine());
            int b = Integer.parseInt(st.nextToken());
            int[] bScore = new int[5];
            while(st.hasMoreTokens()){
                int score = Integer.parseInt(st.nextToken());
                bScore[score]++;
            }

            for(int i=4; i>0; i--){
                if(aScore[i]>bScore[i]){
                    sb.append("A");
                    break;
                }else if(bScore[i]>aScore[i]){
                    sb.append("B");
                    break;
                }
                if(i==1 && aScore[1]==bScore[1]){
                    sb.append("D");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
