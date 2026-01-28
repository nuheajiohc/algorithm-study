import java.io.*;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            String memory = br.readLine();

            int count = 0;
            char status = '0';
            for(char c : memory.toCharArray()){
                if(status != c){
                    status = c;
                    count++;
                }
            }
            sb.append("#").append(t).append(" ").append(count).append("\n");
        }

        System.out.println(sb);
    }
}
