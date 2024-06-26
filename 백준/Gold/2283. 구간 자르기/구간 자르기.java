import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Map<Integer, Integer> point = new HashMap<>();
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            point.put(a,point.getOrDefault(a,0)+1);
            point.put(b,point.getOrDefault(b,0)-1);
        }

        int sum=0;
        int eCount=0;
        int sCount=0;
        int s=0;
        int e=0;
        while(e<1000001){
            if(sum<K){
                e++;
                eCount+=point.getOrDefault(e-1,0);
                sum+=eCount;
            }else if(sum>K){
                s++;
                sCount+=point.getOrDefault(s-1,0);
                sum-=sCount;
            }else{
                System.out.println(s+" "+e);
                return;
            }
        }
        System.out.println("0 0");
    }
}
