import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        List<Room> rooms = new ArrayList<>();
        while(p-->0){
            st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            String N = st.nextToken();
            boolean isIncluded=false;
            for(Room room : rooms){
                if(Math.abs(room.players.get(0).level-L)<=10 && room.players.size()<m){
                    room.players.add(new Player(L,N));
                    isIncluded = true;
                    break;
                }
            }
            if(!isIncluded){
                Room room = new Room();
                room.players.add(new Player(L,N));
                rooms.add(room);
            }
        }

        for(Room room : rooms){
            if(room.players.size()==m){
                sb.append("Started!").append("\n");
            }else{
                sb.append("Waiting!").append("\n");
            }
            Collections.sort(room.players);
            for(Player player : room.players){
                sb.append(player.level).append(" ").append(player.name).append("\n");
            }
        }
        System.out.println(sb);
    }
    
    public static class Room{
        List<Player> players = new ArrayList<>();
    }

    public static class Player implements Comparable<Player>{
        int level;
        String name;

        Player(int level, String name){
            this.level = level;
            this.name = name;
        }

        @Override
        public int compareTo(Player p){
            return name.compareTo(p.name);
        }
    }
}
