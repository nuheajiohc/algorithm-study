import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Map<Integer, Integer> map = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            
            if(map.containsKey(arr[i])){
                map.put(arr[i], map.get(arr[i])+1);
            }else{
                map.put(arr[i], 1);
            }
        }

        Arrays.sort(arr);        

        int count = 0;
        for(int i=0; i<N; i++){
            for(int j=i+1; j<N; j++){
                int target = K-arr[i]-arr[j];
                if(target<arr[i] || target<arr[j]) continue;
                if(!map.containsKey(target)) continue;
                
                int size = map.get(target);

                if(target==arr[i] && target==arr[j]){
                    if(size>=3){
                        count += size-2;
                        j+=size-1;
                    }
                }else if(target==arr[i] && target!=arr[j]){
                    if(size>1){
                        count += size-1;
                        j+=1;
                    }
                }else if(target==arr[j] && target!=arr[i]){
                    if(size>1){
                        count += size-1;
                        j+=1;
                    }
                }else if(target!=arr[i] && arr[i]==arr[j]){
                    count++;
                }else if(target!=arr[i] && target!=arr[j] && arr[i]!=arr[j]){
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}