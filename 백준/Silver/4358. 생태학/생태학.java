import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line ="";
    Map<String,Integer> map = new TreeMap<>();
    double total=0;
    while((line=br.readLine())!=null){
      map.put(line, map.getOrDefault(line,0)+1);
      total++;
    }

    StringBuilder sb = new StringBuilder();
    for(String species : map.keySet()){
      String value =String.format("%.4f",map.get(species)*100/total);
      sb.append(species).append(" ").append(value).append("\n");
    }
    System.out.println(sb);
  }
}
