import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        recursion(N,0);
    }

    public static void recursion(int n, int count){
        if(n==0 && count%2==0){
            System.out.println("CY");
            return;
        }
        if(n==0 && count%2==1){
            System.out.println("SK");
            return;
        }
        if(n>=3) recursion(n-3,count+1);
        else recursion(n-1,count+1);
    }
}
