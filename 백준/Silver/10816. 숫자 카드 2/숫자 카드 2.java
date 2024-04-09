import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static int[] card;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        card = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            card[i] = Integer.parseInt(st.nextToken());
        }

        br.readLine();
        st = new StringTokenizer(br.readLine());
        StringBuilder sb= new StringBuilder();
        Arrays.sort(card);
        while(st.hasMoreTokens()){
            int target = Integer.parseInt(st.nextToken());
            sb.append(upperIdx(target)-lowerIdx(target)).append(" ");
        }
        System.out.println(sb.toString());
    }

    public static int upperIdx(int target){
        int st=0;
        int en=N;
        while(st<en){
            int mid = (st+en)/2;
            if(card[mid]<=target) st=mid+1;
            else en=mid; 
        }
        return st;
    }

    public static int lowerIdx(int target){
        int st=0;
        int en=N;
        while(st<en){
            int mid = (st + en)/2;
            if(card[mid]<target) st=mid+1;
            else en=mid;
        }
        return st;
    }
}
