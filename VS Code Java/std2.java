import java.util.*;
import java.io.*;
public class std2 {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Kattio io = new Kattio();
        int n = io.nextInt();
        String line = io.next() + "0";
        int a = 999999999;
        int count = 0; int b = 0;
        for (int i = 0; i < line.length(); i++) {
            if (line.substring(i,i+1).equals("1")) {
                if (i == 0 || i == line.length() - 2) {
                    count++;
                    b++;
                }
                count++;
                b++;
            } else {
                if (b < a && b != 0) {
                    if (b % 2 == 0) {
                        count--;
                        b--;
                    }
                    a = b;
                    b = 0;
                }
            }
        }
        io.println(count/a);
        io.close();
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