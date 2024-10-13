import java.util.*; import java.io.*;
public class BestFit {
    public static void main(String[] args) {
        while (true) { 
            Scanner in = new Scanner(System.in);
            System.out.println("break?, say y");
            if (in.next().equals("y")) {
                break;
            }
            System.out.println("number of points?");
            int n = in.nextInt();
            Point[] list = new Point[n];
            System.out.println("insert set of points, one at a time, space separate values");
            for (int i = 0; i < n; i++) {
                list[i] = new Point(in.nextInt(), in.nextInt());
            }
            System.out.println(lineGen(list, n)); 
        }
        System.out.println("*boot sfx*");
    }
    static String lineGen(Point[] list, int n) {
        int sumX = 0; int sumY = 0; int sumXY = 0; int sumXV2 = 0;
        for (int i = 0; i < n; i++) {
            sumX += list[i].x;
            sumY += list[i].y;
            sumXY += (list[i].x*list[i].y);
            sumXV2 += (list[i].x*list[i].x);
        }
        int a = ((n*sumXY) - (sumX*sumY));
        int b = ((n*sumXV2) - (sumX*sumX));
        int c = ((b*sumY - a*sumX));
        return ("y = " + simp(a,b) + "x + " + simp(c,n*b));
        
    }
    static String simp(int a, int b) {
        if (a < 0 && b < 0) {
            a = Math.abs(a);
            b = Math.abs(b);
        }
        for (int i = Math.max(a, b); i > 0; i--) {
            if (a % i == 0 && b % i == 0) {
                a /= i;
                b /= i;
            }
        }
        if (b == 1) {
            return (a + "");
        }
        if (b == 0) {
            return ("undefined");
        }
        if (a == 0) {
            return ("0");
        }
        return (a + "/" + b);
    }
    static class Point {
        int x; int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}