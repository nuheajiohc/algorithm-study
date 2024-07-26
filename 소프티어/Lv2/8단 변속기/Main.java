import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] nums = new int[8];
        for(int i=0; i<8; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int count=0;
        for(int i=0; i<7; i++){
            if(nums[i]+1 == nums[i+1]){
                count++;
            }else if(nums[i]-1 == nums[i+1]){
                count--;
            }else{
                break;
            }
        }
        if(count==7){
            System.out.println("ascending");
        }else if(count==-7){
            System.out.println("descending");
        }else{
            System.out.println("mixed");
        }
    }
}
