import java.util.*;
import java.io.*;
public class taming {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Kattio io = new Kattio("taming");
        int n = io.nextInt();
        int count = 0; int worst = 0;
        int[] log = new int[n];
        for (int i = 0; i < n; i++) {
            log[i] = io.nextInt();
            if (log[i] != -1) {
                for (int j = 1; j <= log[i]; j++) {
                    log[i-j] = log[i] - j;
                }
            }
        }
        log[0] = 0;
        for (int i = 0; i < n; i++) {
            if (log[i] == 0) {
                count++;
            }
            if (log[i] == -1) {
                worst++;
            }
        }
        io.println((count) + " " + (count+worst));
        io.close();
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
        } catch (Exception e) {}
        return null;
    }
    public int nextInt() { return Integer.parseInt(next()); }
}