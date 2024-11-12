import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int underX1 = Integer.parseInt(st.nextToken());
            int underY1 = Integer.parseInt(st.nextToken());
            int upperX1 = Integer.parseInt(st.nextToken());
            int upperY1 = Integer.parseInt(st.nextToken());
            Rectangle rectangle1 = new Rectangle(underX1, underY1, upperX1, upperY1);
            int underX2 = Integer.parseInt(st.nextToken());
            int underY2 = Integer.parseInt(st.nextToken());
            int upperX2 = Integer.parseInt(st.nextToken());
            int upperY2 = Integer.parseInt(st.nextToken());

            Rectangle rectangle2 = new Rectangle(underX2, underY2, upperX2, upperY2);

            if (hasNoCommon(rectangle1, rectangle2)) {
                sb.append("d");
            } else if (hasPoint(rectangle1, rectangle2)) {
                sb.append("c");
            } else if (hasLine(rectangle1, rectangle2)) {
                sb.append("b");
            } else {
                sb.append("a");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static class Rectangle {
        int x1;
        int y1;
        int x2;
        int y2;

        public Rectangle(int x1, int y1, int x2, int y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }
    }

    public static boolean hasNoCommon(Rectangle r1, Rectangle r2) {
        return r1.x2 < r2.x1 ||
                r1.x1 > r2.x2 ||
                r1.y1 > r2.y2 ||
                r2.y1 > r1.y2;
    }

    public static boolean hasPoint(Rectangle r1, Rectangle r2) {
        return (r1.x1 == r2.x2 && r1.y1 == r2.y2) ||
                (r1.x1 == r2.x2 && r1.y2 == r2.y1) ||
                (r1.x2 == r2.x1 && r1.y2 == r2.y1) ||
                (r1.x2 == r2.x1 && r1.y1 == r2.y2);
    }

    public static boolean hasLine(Rectangle r1, Rectangle r2) {
//        return (r1.x1==r2.x2) && (r2.y1<r1.y2 && r2.y1>=r1.y1) ||
//                (r1.x1==r2.x2) && (r2.y2>r1.y1 && r2.y2<=r1.y2) ||
//                (r1.x2==r2.x1) && (r2.y1<r1.y2 && r2.y1>=r1.y1) ||
//                (r1.x2==r2.x1) && (r2.y2>r1.y1 && r2.y2<=r1.y2) ||
//                (r1.y1==r2.y2) && (r2.x2>r1.x1 && r2.x2<=r1.x2) ||
//                (r1.y1==r2.y2) && (r2.x1>=r1.x1 && r2.x1<r1.x2) ||
//                (r1.y2==r2.y1) && (r2.x2>r1.x1 && r2.x2<=r1.x2) ||
//                (r1.y2==r2.y1) && (r2.x1>=r1.x1 && r2.x1<r1.x2);
        return r1.x2==r2.x1 || r1.y2==r2.y1 || r1.x1==r2.x2 || r1.y1==r2.y2;
     }
}
