import java.util.*; import java.io.*;
public class cannonball {
    static int n;
    static Point[] line;
    public static void main(String[] args) throws Exception {
        Kattio io = new Kattio();
        n = io.nextInt();
        int m = io.nextInt() - 1;
        line = new Point[n];
        for (int i = 0; i < n; i++) {
            line[i] = new Point(io.nextInt(), io.nextInt());
        }
        int a = go(0,m,1,1,-1);
        io.println(a);
        io.close();
    }
    static int go(int count, int m, int pow, int dir, int lastbump) {
        if (m < 0 || m > n-1 || (line[m].val == 0 && lastbump == 0 && line[m].type == 0)) {
            return count;
        }
        if (line[m].type == 0) {
            pow += line[m].val;
            dir *= -1;
            lastbump = line[m].val;
        } else if (line[m].type == 1 && pow >= line[m].val) {
            count++;
            line[m].type++;
        }
        m += dir*pow;

        return go(count, m, pow, dir, lastbump);
    }
    static class Point {
        int type; int val;
        public Point(int type, int val) {
            this.type = type; 
            this.val = val;
        }
    }
}
class Kattio extends PrintWriter {
    private BufferedReader r; private StringTokenizer st;
    public Kattio() { this(System.in, System.out); }
    public Kattio(InputStream i, OutputStream o) {
        super(o);
        r = new BufferedReader(new InputStreamReader(i));
    }
    public String next() {
        try {
            while (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(r.readLine());
            }
            return st.nextToken();
        } catch (Exception e) {}
        return null;
    }
    public int nextInt() { return Integer.parseInt(next()); }
 }
 