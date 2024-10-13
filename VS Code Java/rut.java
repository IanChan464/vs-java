import java.util.*;
import java.io.*;
public class rut {
    public static void main(String[] args) throws IOException, FileNotFoundException {
        Kattio io = new Kattio();
        int n = io.nextInt();
        cow[] list = new cow[n];
        for (int i = 0; i < n; i++) {
            if (io.next().equals("E")) {
                list[i] = cow(0, io.nextInt(), io.nextInt(), false);
            } else {
                list[i] = cow(1, io.nextInt(), io.nextInt(), false);
            }
        }
    }
    static void go(cow[] list) {
        if ( for (int i = 0; i < list.length, i++) { if ()})
    }
    static class cow {
        int direction; int x; int y; boolean stopped;
        public cow(int direction, int x, int y, boolean stopped) {
            this.direction = direction;
            this.x = x;
            this.y = y;
            this.stopped = stopped;
        }
    }
}
class Kattio extends PrintWriter {
    private StringTokenizer st; private BufferedReader r;
    public Kattio() { this(System.in, System.out); }
    public Kattio(InputStream i, OutputStream o) {
        super(o);
        r = new BufferedReader(new InputStreamReader(i));
    }
    public String next() {
        try {
            while (st == null||!st.hasMoreTokens()) {
                st = new StringTokenizer(r.readLine());
            }
            return st.nextToken();
        } catch (Exception e) {}
        return null;
    }
}