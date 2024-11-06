import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N ;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> list = new LinkedList<>();
        for(int i=N-1; i>=0; i--){
            list.add(arr[i],i+1);
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0 ;i<N; i++){
            sb.append(list.get(i)).append(" ");
        }
        System.out.println(sb);
    }
}
