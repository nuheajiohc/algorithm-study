import java.io.*;
import java.util.*;

public class Main {

    private static String T;
    private static int N;
    private static Book[] books;
    private static int minimum = Integer.MAX_VALUE;
    private static boolean[] used;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = br.readLine();
        N = Integer.parseInt(br.readLine());

        used = new boolean[N];
        books = new Book[N];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int price = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            books[i] = new Book(price, name);
        }

        find(0);
        if(minimum==Integer.MAX_VALUE){
            System.out.println(-1);
        }else{
            System.out.println(minimum);
        }
    }

    public static void find(int k){
        if(k==N){
            boolean[] check = new boolean[T.length()];
            for(int i=0; i<N; i++){
                if(used[i]){
                    for(int j=0; j<books[i].name.length(); j++){
                        for(int l=0; l<T.length(); l++){
                            if(!check[l] && (books[i].name.charAt(j)==T.charAt(l))){
                                check[l]=true;
                                break;
                            }
                        }
                    }
                }
            }
            int count=0;
            for(int i=0; i<T.length(); i++){
                if(check[i]){
                    count++;
                }
            }
            if(count==T.length()){
                int sumPrice=0;
                for(int i=0; i<N; i++){
                    if(used[i]){
                        sumPrice += books[i].price;
                    }
                }
                minimum = Math.min(minimum, sumPrice);
            }
            return;
        }

        used[k] = false;
        find(k+1);

        used[k] = true;
        find(k+1);

    }

    public static class Book{
        int price;
        String name;

        public Book(int price, String name){
            this.price = price;
            this.name = name;
        }
    }
}
