import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        String game = st.nextToken();
        Set<String> set = new HashSet<>();
        for(int i=0; i<N; i++){
            set.add(br.readLine());
        }
        int result=0;
        switch(game){
            case "Y":
                result = set.size();
                break;
            case "F":
                result = set.size()/2;
                break;
            case "O":
                result = set.size()/3;
                break;
        }
        System.out.println(result);
    }
}
