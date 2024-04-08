import java.io.*;
import java.util.*;

public class Main {

    private static int[] A;
    private static int N;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(st.hasMoreTokens()){
            sb.append(binarySearch(Integer.parseInt(st.nextToken()))).append("\n");
        }
        System.out.println(sb.toString());
    }

    public static int binarySearch(int target){
        int st = 0;
        int en = N-1;
        while(st<=en){
            int mid = (st+en)/2;
            if(target>A[mid]){
                st = mid+1;
            }else if(target<A[mid]){
                en = mid-1;
            }else{
                return 1;
            }
        }
        return 0;
    }
}
