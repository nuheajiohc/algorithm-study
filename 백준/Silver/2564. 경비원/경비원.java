import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int w, h;
    private static int[] road;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(br.readLine());

        int[][] arr =new int[n][2];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int pos = check(a,b);
        
        int min=0;
        for(int i=0; i<n; i++){
            int target= check(arr[i][0],arr[i][1]);
            min += Math.min(Math.abs(pos-target),Math.abs(2*(w+h)-Math.abs(pos-target)));
        }
        System.out.println(min);
        
    }

    public static int check(int a, int b) {
        if (a == 1) {
            return b;
        } else if (a == 2) {
            return w + h + (w - b);
        } else if (a == 3) {
            return w + h + w + (h - b);
        } else {
            return w + b;
        }
    }
}
