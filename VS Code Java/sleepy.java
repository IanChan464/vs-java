import java.util.*;
import java.io.*;
public class sleepy {
    public static void main(String[] args) throws IOException, FileNotFoundException {
        Kattio io = new Kattio("sleepy");
        int n = io.nextInt();
        int[] line = new int[n];
        for (int i = 1; i <= n; i++) {
            line[line.length-i] = io.nextInt();
        }
        for (int i = 1; i <= n; i++) {
            if (line[i] == 1) {
                io.println(n-i-1);
                io.close();
                break;
            }
            if (line[i] >= line[i-1]) {
                io.println(n-i);
                io.close();
                break;
            }
        }
    }
}
class Kattio extends PrintWriter {
    private BufferedReader r; private StringTokenizer st;
    public Kattio(String problemName) throws IOException {
        super(problemName + ".out");
        r = new BufferedReader(new FileReader(problemName + ".in"));
    }
    public String next() {
        try {
            while (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(r.readLine());
            }
            return st.nextToken();
        } catch(Exception e) {}
        return null;
    }
    public int nextInt() { return Integer.parseInt(next()); }
}