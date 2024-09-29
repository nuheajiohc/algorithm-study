import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    StringBuilder sb= new StringBuilder();
    while(T-->0){
      StringTokenizer st = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(st.nextToken());
      int M = Integer.parseInt(st.nextToken());
      Integer[] arr = new Integer[N];
      st = new StringTokenizer(br.readLine());
      for(int i = 0; i < N; i++){
        arr[i] = Integer.parseInt(st.nextToken());
      }
      Queue<Document> q = new ArrayDeque<>();
      for(int i = 0; i < N; i++){
        q.offer(new Document(i,arr[i]));
      }

      int count=0;
      Arrays.sort(arr,(a,b)->b-a);
      for(int num : arr){
        while(q.peek().important!=num){
          q.offer(q.poll());
        }
        if(q.peek().important==num){
          count++;
          if(q.peek().idx==M) break;
          q.poll();
        }
      }
      sb.append(count).append("\n");
    }
    System.out.println(sb);
  }

  public static class Document{
    int idx;
    int important;

    public Document(int idx, int important) {
      this.idx = idx;
      this.important = important;
    }
  }
}
