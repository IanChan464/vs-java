import java.util.*;
import java.io.*;
public class badmilk {
    public static void main(String[] args) throws IOException, FileNotFoundException {
        Kattio io = new Kattio("badmilk");
        int n = io.nextInt();
        int m = io.nextInt();
        int d = io.nextInt();
        int s = io.nextInt();
    }
class drink {
    
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
            while(st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(r.readLine());
            }
            return st.nextToken();
        } catch (Exception e) {}
        return null;
    }
    public int nextInt() { return Integer.parseInt(next()); }
}