import java.io.*;
import java.util.*;

public class Main {

    static List<Long> nums = new ArrayList<>();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        for(int i=0; i<10; i++){
            recursion(i, i);
        }
        int N = Integer.parseInt(br.readLine());

        Collections.sort(nums);
        if(nums.size()>N){
            System.out.println(nums.get(N));
        }else{
            System.out.println(-1);
        }
    }

    static void recursion(int k, long num){
        nums.add(num);

        for(int i=0; i<k; i++){
            recursion(i, num*10 + i);
        }
    }
}
