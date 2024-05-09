import java.io.*;
import java.util.*;

public class Main {

    private static int N,M,L;
    private static int[] restArea;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        restArea = new int[N+2];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            restArea[i] = Integer.parseInt(st.nextToken());
        }
        restArea[N]=0;
        restArea[N+1]=L;
        Arrays.sort(restArea);

        int s=0;
        int e=L;
        while(s+1<e){
            int mid = (s+e)/2;
            if(check(mid)) e=mid;
            else s=mid;
        }
        System.out.println(e);
    }

    public static boolean check(int target){
        int count=0;
        for(int i=1; i<restArea.length; i++){
            count+= ((restArea[i]-restArea[i-1])/target)-1;
            if((restArea[i]-restArea[i-1])%target!=0) count++;
        }
        return M>=count;
    }
}
