import java.util.*;
import java.io.*;
public class dist {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Kattio io = new Kattio();
        int n = io.nextInt();
        point[] list = new point[n];
        int dist = 0;
        for (int i = 0; i < n; i++) {
            list[i].x = io.nextInt();
        }
        for (int i = 0; i < n; i++) {
            list[i].y = io.nextInt();
        }
        for (int i = 0; i < n-1; i++) {
            for (int j = i + 1; j < n; j++) {
                dist = Math.max(dist, (list[i].x - list[j].x * list[i].x - list[j].x) + (list[i].y - list[j].y * list[i].y - list[j].y));
            }
        }
        io.println(dist);
        io.close();
    }
class point {
    int x, y;
    point(int x, int y) {
        this.x = x;
        this.y = y;
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
            while(st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(r.readLine());
            }
            return st.nextToken();
        } catch (Exception e) {}
        return null;
    }
    public int nextInt() { return Integer.parseInt(next()); }
}