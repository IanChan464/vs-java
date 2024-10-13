import java.util.*; import java.io.*;
public class bacteria {
    public static void main(String[] args) throws Exception {
        Kattio io = new Kattio(); 
        int n = io.nextInt();
        long[] grass = new long[n];
        long count = 0;
        long a;
        Queue<Long>
        for (int i = 0; i < n; i++) {
            grass[i] = io.nextLong();
        }
        for (int i = 0; i < n - 1; i++) {
            count += Math.abs(grass[i]);
            a = grass[i];
            grass[i] = 0;
            for (int j = i + 1; j < n; j++) {
                count += Math.abs(grass[i]);
                grass[j] -= (j-i+1)*(a);
            }
        }

        count += Math.abs(grass[grass.length-1]);
        
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
    public long nextLong() { return Long.parseLong(next());}
 }