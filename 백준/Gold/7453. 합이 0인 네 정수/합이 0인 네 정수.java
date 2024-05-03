import java.io.*;
import java.util.*;

public class Main {

    private static int[] AB,CD;
    private static int N;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        int[] B = new int[N];
        int[] C = new int[N];
        int[] D = new int[N];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            A[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
            C[i] = Integer.parseInt(st.nextToken());
            D[i] = Integer.parseInt(st.nextToken());
        }

        AB = new int[N*N];
        CD = new int[N*N];
        int k=0;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                AB[k]=A[i]+B[j];
                CD[k]=C[i]+D[j];
                k++;
            }
        }
        
        Arrays.sort(AB);
        Arrays.sort(CD);

        long count=0;
        for(int i=0; i<N*N; i++){
            count+=(long)(upperBound(CD,AB[i])-lowerBound(CD,AB[i]));
        }
        System.out.println(count);
    }

    public static int lowerBound(int[] sum, int target){
        int st = -1;
        int en = sum.length;
        while(st+1<en){
            int mid = (st+en)/2;
            if(target+sum[mid]<0) st=mid;
            else en=mid;
        }
        return st;
    }

    public static int upperBound(int[] sum, int target){
        int st = -1;
        int en = sum.length;
        while(st+1<en){
            int mid = (st+en)/2;
            if(target+sum[mid]<=0) st=mid;
            else en=mid; 
        }
        return st;
    }
}
