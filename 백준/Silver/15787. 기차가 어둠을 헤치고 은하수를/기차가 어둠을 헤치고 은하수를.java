import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int th = Integer.parseInt(st.nextToken());
            int sit;
            if(command == 1){
                sit = Integer.parseInt(st.nextToken());
                arr[th-1] |= (1 << (sit-1));
            }else if(command == 2){
                sit = Integer.parseInt(st.nextToken());
                arr[th-1] &= ~(1 << (sit-1));
            }else if(command ==3){
                arr[th-1] = (arr[th-1] << 1) & ~(1<<20);
            }else{
                arr[th-1] >>= 1;
            }
        }
        Set<Integer> set = new HashSet<>();
        for(int n : arr){
            set.add(n);
        }
        System.out.println(set.size());
    }
}
