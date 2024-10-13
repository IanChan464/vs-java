import java.util.*; import java.io.*;
public class drought {
    public static void main(String[] args) throws IOException, FileNotFoundException {
        ArrayList<Integer> list = new ArrayList<>();
        Kattio io = new Kattio();
        int t = io.nextInt();
        for (int i = 0; i < t; i++) {
            int n = io.nextInt();
            for (int j = 0; j < n; j++) {
                list.add(io.nextInt());
            }
            io.println(getTimes(list, 0));
            list.clear();
        }
        io.close();
    }
    static int getTimes(ArrayList<Integer> list, int count) {
        int maxAt = 0;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) != list.get(i-1)) {
                break;
            }
            return count;
        }
        if (list.size() == 2) {
            return (-1);
        }
        for (int i = 1; i < list.size() - 1; i++) {
            if (list.get(i) == -1) { return(-1); }
            maxAt = ((int)list.get(i) > (int)list.get(maxAt)) ? i : maxAt;
        }
        list.set(maxAt, (int)list.get(maxAt) - 1);
        if ((int)list.get(maxAt + 1) > (int)list.get(maxAt - 1)) {
            list.set(maxAt + 1, (int)list.get(maxAt) - 1);
            return getTimes((ArrayList)list, count + 1);
        }
        list.set(maxAt - 1, (int)list.get(maxAt) - 1);
        return getTimes(list, count + 1);      
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
 