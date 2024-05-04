import java.io.*;
import java.util.*;

public class Main {

    private static int[] regions;
    private static int upperBound;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        regions = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int maxRequest = 0;
        for(int i=0; i<N; i++){
            regions[i] = Integer.parseInt(st.nextToken());
            maxRequest = Math.max(regions[i],maxRequest);
        }
        upperBound = Integer.parseInt(br.readLine());

        int s=1;
        int e=maxRequest+1;
        while(s+1<e){
            int mid = (s+e)/2;
            if(check(mid)) s=mid;
            else e=mid;
        }
        System.out.println(s);
    }

    public static boolean check(int target){
        int budget = 0;
        for(int region : regions){
            if(target<region){
                budget += target;
            }else{
                budget += region;
            }
        }
        return budget <= upperBound;
    }
}