import java.io.*;
import java.util.*;

public class Main {

    private static int A,B;
    private static int[] Aarr, Barr;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        while(T-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            Aarr = new int[A];
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<A; i++){
                Aarr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(Aarr);

            Barr = new int[B];
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<B; i++){
                Barr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(Barr);
            int count=0;
            for(int i=0; i<A; i++){
                count+=upperBound(Aarr[i]);
            }
            sb.append(count).append("\n");
        } 
        System.out.println(sb.toString());
    }

    public static int upperBound(int target){
        int st=-1;
        int en=B;
        while(st+1<en){
            int mid = (st+en)/2;
            if(target>Barr[mid]) st=mid;
            else en = mid;
        }
        return en;
    }
}
