import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        String str = br.readLine();
        boolean[] used = new boolean[N];

        int ans = 0;
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i)=='P'){
                int start = Math.max(i-K, 0);
                int end = Math.min(i+K, str.length()-1);
                for(int j=start; j<=end; j++){
                    if(j==i) continue;
                    if(str.charAt(j) == 'P') continue;
                    if(used[j]) continue;
                    used[j]=true;
                    ans++;
                    break;
                }
            }
        }

        System.out.println(ans);
    }
}