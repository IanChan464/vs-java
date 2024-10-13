import java.util.*;
import java.io.*;
public class breedflip {
    public static void main(String[] args) throws IOException, FileNotFoundException {
        Kattio io = new Kattio ("breedflip");
        int n = io.nextInt();
        int mode = 0; int count = 0;
        String a = io.next();
        String b = io.next();
        for (int i = 0; i < n; i++) {
            if (a.substring(i, i+1).equals(b.substring(i, i+1))) {
                mode = 0;
            } else if (a.substring(i,i+1).equals("H")) {
                if (mode != 1) {
                    count++;
                }
                mode = 1;
            } else {
                if (mode != 2) {
                    count++;
                }
                mode = 2;
            }
        }
        io.println(count);
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