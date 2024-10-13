import java.io.*;
import java.util.*;
public class distinct {
    public static void main(String[] args) throws IOException, FileNotFoundException {
        Kattio io = new Kattio();
        int n = io.nextInt();
        int[] list = new int[n];
        int count = 1;
        for (int i = 0; i < n; i++) {
            list[i] = io.nextInt();
        }
        Arrays.sort(list);
        for (int i = 0; i < n - 1; i++) {
            if (list[i] != list[i+1]) {
                count++;
            }
        }
        io.println(count);
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