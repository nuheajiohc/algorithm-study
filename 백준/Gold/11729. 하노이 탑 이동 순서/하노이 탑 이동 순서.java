import java.io.*;

public class Main {
    
    private static int N,count;
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        hanoi(1,3,N);
        System.out.println(count);
        System.out.println(sb.toString());
    }

    public static void hanoi(int cur, int next, int n){
        if(n==0) return;

        hanoi(cur,6-cur-next,n-1);
        sb.append(cur).append(" ").append(next).append("\n");
        count++;
        hanoi(6-cur-next,next,n-1);
    }
}
