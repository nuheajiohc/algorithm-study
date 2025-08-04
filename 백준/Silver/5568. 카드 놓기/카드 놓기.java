import java.io.*;
import java.util.*;

public class Main {

    private static Set<String> set = new HashSet<>();
    private static String[] arr;
    private static boolean[] used;
    private static int N,K;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        used = new boolean[N];
        arr = new String[N];
        for(int i=0; i<N; i++){
            arr[i] = br.readLine();
        }

        check(0,"");
        System.out.println(set.size());
    }

    public static void check(int k, String num){
        if(k==K){
            set.add(num);
            return;
        }

        for(int i=0; i<N; i++){
            if(used[i]) continue;
            used[i]=true;
            check(k+1, num+arr[i]);
            used[i]=false;
        }
    }
}
