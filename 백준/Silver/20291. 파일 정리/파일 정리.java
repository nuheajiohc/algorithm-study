import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    Map<String, Integer> map = new TreeMap<>();
    while(N-->0){
      String line = br.readLine();
      StringTokenizer st = new StringTokenizer(line,".");
      String name = st.nextToken();
      String extension = st.nextToken();
      map.put(extension, map.getOrDefault(extension,0)+1);
    }

    StringBuilder sb=  new StringBuilder();
    map.forEach((k,v)-> sb.append(k).append(" ").append(v).append("\n"));
    System.out.println(sb);
  }
}
