      import java.io.*;
      import java.util.*;
      
      public class target {
      
        static Scanner in;
        static TreeSet<Integer> points;
        static Rectangle[] targets;
        static int[] slopes;
        static boolean skip;
      
        public static void main(String[] args) throws Exception {
          in = new Scanner(System.in);
          int t = in.nextInt(); int n; int x1;
          for (int j = 0; j < t; j++) {
            skip = false;
            n = in.nextInt();
            x1 = in.nextInt();
            points = new TreeSet<>();
            targets = new Rectangle[n];
            for (int i = 0; i < n; i++) {
                targets[i] = new Rectangle(x1, in.nextInt(), in.nextInt(), in.nextInt());
            }
            for (int i = 0; i < n; i++) {
                slopes = new int[4];
                slopes[0] = in.nextInt();
                slopes[1] = in.nextInt();
                slopes[2] = in.nextInt();
                slopes[3] = in.nextInt();
                Arrays.sort(slopes);
                if ((slopes[1] >= 0 || slopes[2] <= 0) && !skip) {
                    System.out.println("-1");
                    skip = true;
                } else {
                    points.add(-(slopes[0]*x1) + targets[i].y1); points.add(-(slopes[1]*targets[i].x2) + targets[i].y2); points.add(-(slopes[2]*targets[i].x2) + targets[i].y1); points.add(-(slopes[3]*x1) + targets[i].y2);
                }
            }
            if (!skip) {
                System.out.println(points.last() - points.first());
                System.out.println(points + "");
                for (int i = 0; i < targets.length; i++) {
                    System.out.println(targets[i].x1 + " " + targets[i].x2 + " " + targets[i].y1 + " " + targets[i].y2);
                }
            }
            points.clear();
        }
        }
        static class Rectangle {
            int x1; int x2; int y1; int y2;
            public Rectangle(int x1, int y1, int y2, int x2) {
                this.x1 = x1;
                this.x2 = x2;
                this.y1 = y1;
                this.y2 = y2;
            }
        }
    }