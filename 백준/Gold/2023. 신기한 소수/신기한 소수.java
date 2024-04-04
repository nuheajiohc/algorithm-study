import java.io.*;

public class Main {

    private static int N;
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        backtracking(0,"");
        System.out.println(sb.toString());
    }

    public static boolean isPrime(int n){
        if(n==1){
            return false;
        }
        for(int i=2; i*i<=n; i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }

    public static void backtracking(int depth,String str){
        if(depth==N){
            sb.append(str).append("\n");
            return;
        }

        for(int i=1; i<10; i++){
            String temp = str + String.valueOf(i);
            if(!isPrime(Integer.parseInt(temp))){
                continue;
            }
            backtracking(depth+1, temp);
        }
    }
}
