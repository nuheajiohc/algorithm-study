import java.io.*;
import java.util.*;

public class Main {

    private static int n,m;
    private static int[] arr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n+1];
        for(int i=1; i<=n; i++){
            arr[i] = i;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(c==0){
                union(a,b);
            }else{
                if(find(a)==find(b)){
                    sb.append("YES");
                }else{
                    sb.append("NO");
                }
                sb.append("\n");
            }
        }

        System.out.println(sb);
    }

    public static void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a<b){
            arr[b] = a;
        }else{
            arr[a] = b;
        }
    }

    public static int find(int x){
        if(arr[x] == x){
            return x;
        }
        return arr[x] = find(arr[x]);
    }
}
