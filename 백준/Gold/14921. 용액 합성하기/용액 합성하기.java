import java.util.*;
import java.io.*;

public class Main {
    private static int[] A;
    private static int minValue;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i =0; i<N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);
        minValue = Integer.MAX_VALUE;

        for(int i=0; i<N-1; i++){
            int s = i;
            int e = N;
            while(s+1<e){
                int mid = (s+e)/2;
                if(check(i,mid)) s=mid;
                else e=mid;
            }
        }
        System.out.println(minValue);
    }

    public static boolean check(int value, int target){
        int temp = A[value]+A[target];
        if(Math.abs(temp)<Math.abs(minValue)){
            minValue = temp;
        }
        return temp<0;
    }
}
