import java.util.*;
import java.io.*;

public class Main {

    private static int[] house;
    private static int N,C;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        house = new int[N];
        for(int i=0; i<N; i++){
            house[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(house);

        int s=0;
        int e=1000000001;
        while(s+1<e){
            int mid = (s+e)/2;
            if(check(mid)) s =mid;
            else e =mid;
        }
        System.out.println(s);
    }

    public static boolean check(int target){
        int count=1;
        int s=0;
        int e=1;
        while(e<N){
            if(house[e]-house[s]>=target){
                s=e;
                count++;
            }
            e++;
        }
        return count>=C;
    }
}
