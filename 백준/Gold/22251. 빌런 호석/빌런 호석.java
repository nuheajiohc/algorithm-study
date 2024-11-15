import java.io.*;
import java.util.*;

public class Main {

    private static int[] arr,num,convert;
    private static int N,K,P,X;
    private static int result;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        num = new int[10];
        num[0] = 119;
        num[1] = 18;
        num[2] = 93;
        num[3] = 91;
        num[4] = 58;
        num[5] = 107;
        num[6] = 111;
        num[7] = 82;
        num[8] = 127;
        num[9] = 123;

        arr = new int[K];
        convert = new int[K];
        int xx=X;
        for(int i = 0; i < K; i++){
            arr[i] = xx%10;
            xx/=10;
        }

        recur(0, P, 0);
        System.out.println(result);
    }

    public static void recur(int depth, int p, int zero){
        if(p<0) return;
        if(depth==K ){
            if(zero<K){
                int sum=0;
                for(int i=K-1; i>=0; i--){
                    sum= sum*10+convert[i];
                }
                if(sum<=N && sum!=X){
                    result++;
                }
            }
            return;
        }

        for(int i=0; i<10; i++){
            int count = diff(num[arr[depth]]^num[i]);
            convert[depth] = i;
            recur(depth+1, p-count, i==0?zero+1:zero);
        }
    }

    public static int diff(int n){
        int count=0;
        while(n>0){
            if(n%2==1) count++;
            n/=2;
        }
        return count;
    }
}