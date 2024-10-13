import java.util.*; import java.io.*;
public class majority {
    public static void main(String[] args) throws Exception {
        Kattio io = new Kattio();
        int t = io.nextInt();
        int n; int prev; int k; int prev2; int o;
        HashSet<Integer> set = new HashSet<>();
        for (int j = 0; j < t; j++) {
            set.clear();
            n = io.nextInt();
            prev2 = io.nextInt();
            prev = io.nextInt();
            if (prev == prev2) {
                set.add(prev);
            }
            for (int i = 2; i < n; i++) {
                k = io.nextInt();
                if ((k == prev || k == prev2) && !set.contains(k)) {
                    set.add(k);
                }
                prev2 = prev;
                prev = k;
                
            }
            if (set.size() == 0) {
                io.print("-1");
            } else {
                Integer[] list = set.toArray(new Integer[set.size()]);
                Arrays.sort(list);
                for (int i = 0; i < list.length - 1; i++) {
                    io.print(list[i] + " ");
                }
                io.print(list[list.length-1]);
            }
            io.println();
        }
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
 