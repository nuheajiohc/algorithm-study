import java.io.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        while(T-->0){
            String W = br.readLine();
            int K = Integer.parseInt(br.readLine());

            ArrayList<Integer>[] positions = new ArrayList[26];
            for(int i=0; i<26; i++){
                positions[i] = new ArrayList<>();
            }

            for(int i=0; i<W.length(); i++){
                positions[W.charAt(i) - 'a'].add(i);
            }

            int min=Integer.MAX_VALUE;
            int max = -1;
            for(int i=0; i<26; i++){
                ArrayList<Integer> position = positions[i];
                if(position.size()<K) continue;
                for(int j=0; j<=position.size()-K; j++){
                    min = Math.min(min, position.get(j+K-1)-position.get(j)+1);
                    max = Math.max(max, position.get(j+K-1)-position.get(j)+1);
                }
            }

            if(max!=-1){
                sb.append(min).append(" ");
            }
            sb.append(max).append("\n");
        }
        System.out.println(sb);
    }
}
