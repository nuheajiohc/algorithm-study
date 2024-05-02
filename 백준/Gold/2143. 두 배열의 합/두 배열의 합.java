import java.io.*;
import java.util.*;

public class Main {

    private static int T;
    private static List<Long> nTotalSum, mTotalSum;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        
        int N = Integer.parseInt(br.readLine());
        long[] Nsum = new long[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            Nsum[i] = Integer.parseInt(st.nextToken())+Nsum[i-1];
        }
        nTotalSum = new ArrayList<>();
        for(int i=1;i<N+1; i++){
            for(int j=0; j<i; j++){
                nTotalSum.add(Nsum[i]-Nsum[j]);
            }
        }
        Collections.sort(nTotalSum);

        int M = Integer.parseInt(br.readLine());
        long[] Msum = new long[M+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=M; i++){
            Msum[i] = Integer.parseInt(st.nextToken())+Msum[i-1];
        }
        mTotalSum = new ArrayList<>();
        for(int i=1;i<M+1; i++){
            for(int j=0; j<i; j++){
                mTotalSum.add(Msum[i]-Msum[j]);
            }
        }
        Collections.sort(mTotalSum);
        long count=0;
        for(long n : nTotalSum){
            count+=upperBound(T-n)-lowerBound(T-n);
        }
        System.out.println(count);
    }

    public static long lowerBound(long target){
        int st=-1;
        int en=mTotalSum.size();
        while(st+1<en){
            int mid = (st+en)/2;
            if(target>mTotalSum.get(mid)) st=mid;
            else en=mid;
        }
        return st;
    }

    public static int upperBound(long target){
        int st=-1;
        int en=mTotalSum.size();
        while(st+1<en){
            int mid= (st+en)/2;
            if(target>=mTotalSum.get(mid)) st=mid;
            else en=mid;
        }
        return st;
    }
 }
