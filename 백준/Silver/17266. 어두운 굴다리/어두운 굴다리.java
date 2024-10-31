import java.io.*;
import java.util.*;

public class Main { 

    private static List<Integer> list = new ArrayList<>();
    private static int N,M;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        M = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++){
            list.add(Integer.parseInt(st.nextToken()));
        }

        int s = -1;
        int e=100000;
        while(s+1<e){
            int mid = (s+e)/2;
            if(!check(mid)) s=mid;
            else e=mid;
        }
        System.out.println(e);
    }

    public static boolean check(int target){
        if(list.get(0)-target>0) return false;
        if(list.get(M-1)+target<N) return false;

        for(int i=1; i<list.size()-1; i++){
            if(list.get(i)-list.get(i-1)>target*2) return false;
        }
        return true;
    }
}
