package 소프티어.Lv2.금고털이;

import java.io.*;
import java.util.*;

// 카운팅 소팅을 이용하여 시간복잡도 O(N)으로 풀이
// 늘 사용할 수 있는 건 아니다 정렬범위가 적절히 적을떄만 가능하다.
public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int W = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] gems = new int[10001];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            gems[p]+=m;
        }

        int price=0;
        int weight=W;
        for(int i=10000; i>0; i--){
            if(weight>gems[i]){
                price+=gems[i]*i;
                weight-=gems[i];
            }else{
                price+=i*weight;
                break;
            }
        }
        System.out.println(price);
    }
}

// 무게까지 정렬하지 않으면 시간초과가 날때가 있음 무게까지 정렬해야한다.
// 시간복잡도 O(NLogN)
// public class Main {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer st = new StringTokenizer(br.readLine());
        // int W = Integer.parseInt(st.nextToken());
        // int N = Integer.parseInt(st.nextToken());
        // int[][] gems = new int[N][2];
        // for(int i=0; i<N; i++){
        //     st = new StringTokenizer(br.readLine());
        //     int m = Integer.parseInt(st.nextToken());
        //     int p = Integer.parseInt(st.nextToken());
        //     gems[i] = new int[]{m,p};
        // }
        // Arrays.sort(gems,(a,b)->{
        //     if(a[1]==b[1]) return b[0]-a[0];
        //     return b[1]-a[1];
        // });

        // int price = 0;
        // int weight = W;
        // for(int i=0; i<N; i++){
        //     if(weight>=gems[i][0]){
        //         price += gems[i][0]*gems[i][1];
        //         weight -= gems[i][0];
        //     }else{
        //         price += weight * gems[i][1];
        //         break;
        //     }
        // }
        // System.out.println(price);
// }


