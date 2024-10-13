import java.util.*;
import java.io.*;
public class shell {
    public static void main(String[] args) throws IOException, FileNotFoundException {
        Kattio io = new Kattio("shell");
        ArrayList<Integer> list = new ArrayList<>();
        int a, b, c;
        int[] count = new int[3];
        count[0] = 0; count[1] = 0; count[2] = 0;
        int f = 0;
        list.add(-1);
        list.add(1);
        list.add(2);
        list.add(3);
        int n = io.nextInt();
        for (int i = 0; i < n; i++) {
            a = io.nextInt();
            b = io.nextInt();
            c = list.get(a);
            list.set(a, list.get(b));
            list.set(b, c);
            f = io.nextInt();
            for (int j = 1; j < 4; j++) {
                if (list.get(f) == j) {
                    count[j-1]++;
                }
            }
        }
        io.println(Math.max(count[0], Math.max(count[1], count[2])));
        io.close();
    }

}
class Kattio extends PrintWriter {
    private StringTokenizer st; private BufferedReader r;
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