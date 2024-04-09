import java.io.*;
import java.util.*;

public class Main {
    private static List<Integer> temp,uni;
    private static int N;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] X = new  int[N];
        temp = new ArrayList<>();
        for(int i=0; i<N; i++){
            X[i] = Integer.parseInt(st.nextToken());
            temp.add(X[i]);
        }

        uni = new ArrayList<>();
        Collections.sort(temp);
        for(int i=0; i<N; i++){
            if(i==0 || !temp.get(i).equals(temp.get(i-1))){
                uni.add(temp.get(i));
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            sb.append(binarySearch(X[i])).append(" ");
        }
        System.out.println(sb.toString());
    }

    public static int binarySearch(int target){
        int st =0;
        int en = uni.size();
        while(st<en){
            int mid = (st+en)/2;
            if(uni.get(mid)<target) st=mid+1;
            else en = mid;
        }
        return st;
    }
}
