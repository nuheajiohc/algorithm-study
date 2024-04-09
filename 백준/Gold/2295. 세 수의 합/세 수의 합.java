import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        for(int i=0; i<N; i++){
            nums[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                list.add(nums[i] + nums[j]);
            }
        }
        Collections.sort(list);
        int[] arr = new int[list.size()];
        for(int i=0; i<list.size();i++){
            arr[i] = list.get(i);
        }
        for(int i=N-1; i>0; i--){
            for(int j=0; j<i; j++){
                if(Arrays.binarySearch(arr,nums[i]-nums[j])>=0){
                    System.out.println(nums[i]);
                    return;
                }
            }
        }
    }
}
