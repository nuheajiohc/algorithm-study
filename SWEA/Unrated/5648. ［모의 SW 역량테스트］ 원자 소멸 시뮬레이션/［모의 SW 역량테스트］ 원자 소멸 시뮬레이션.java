import java.io.*;
import java.util.*;

public class Solution {

    static int[] dx = {0, 0, -1, 1}, dy = {1, -1, 0, 0};
    static int[][] board = new int[4001][4001];
    static List<Atom> atoms;
    static int atomLen;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int tc=1; tc<=TC; tc++){
            int atomLen = Integer.parseInt(br.readLine());

            atoms = new LinkedList<>();
            for(int i=0; i<atomLen; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = (Integer.parseInt(st.nextToken())+1000)*2;
                int y = (Integer.parseInt(st.nextToken())+1000)*2;
                int dir = Integer.parseInt(st.nextToken());
                int K = Integer.parseInt(st.nextToken());
                atoms.add(new Atom(x, y, dir, K));
            }

            int total=0;
            while(!atoms.isEmpty()){
                Iterator<Atom> iter = atoms.iterator();
                while(iter.hasNext()){
                    Atom atom = iter.next();
                    board[atom.x][atom.y] = 0;
                    atom.x = atom.x + dx[atom.dir];
                    atom.y = atom.y + dy[atom.dir];
                    if(atom.x<0 || atom.x>4000 || atom.y<0 || atom.y>4000){
                        iter.remove();
                        continue;
                    }
                    board[atom.x][atom.y] += atom.K;
                }

                for(Atom atom : atoms){
                    if(board[atom.x][atom.y]>atom.K){
                        atom.mark = true;
                        total += atom.K;
                    }
                }

                iter = atoms.iterator();
                while(iter.hasNext()){
                    Atom atom = iter.next();
                    if(atom.mark){
                        iter.remove();
                        board[atom.x][atom.y] = 0;
                    }
                }
            }

            sb.append("#").append(tc).append(" ").append(total).append("\n");
        }
        System.out.println(sb);
    }

    static class Atom{
        int x; int y;
        int dir; int K;
        boolean mark;

        Atom(int x, int y, int dir, int K){
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.K = K;
        }
    }
}
