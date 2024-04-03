import java.io.*;

public class Main {
    public static void main(String[]args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        int count=0;
        int cursor=0;
        int[] stack= new int[K];
        for(int i=0; i<K;i++){
            int n=Integer.parseInt(br.readLine());
            if(n==0 && cursor>0){
                stack[--cursor]=0;
            }else{
                stack[cursor++]=n;
            }
        }

        for(int n:stack){
            count+=n;
        }
        System.out.println(count);
    }
}
