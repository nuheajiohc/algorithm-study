import java.io.*;
import java.util.*;

public class Main {

    public static int[] A;
    public static int N;
    public static int count=0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = new int[N];
        for(int i=0; i<N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);
        for(int i=0; i<N; i++){
            checkSum(i);
        }
        System.out.println(count);
    }

    public static void checkSum(int i){
        for(int j=0; j<i; j++){
            if(Arrays.binarySearch(A,j+1,i,A[i]-A[j])>=0){
                count++;
                return;
            }
            if(Arrays.binarySearch(A,i+1,N,A[i]-A[j])>=0){
                count++;
                return;
            }
        }
        for(int j=i+1; j<N; j++){
            if(Arrays.binarySearch(A,j+1,N,A[i]-A[j])>=0){
                count++;
                return;
            }
        }
    }
}
