import java.util.*;
import java.io.*;
public class mixmilk {
    public static void main(String[] args) throws IOException, FileNotFoundException {
        Kattio io = new Kattio("mixmilk");
        Bucket[] list = new Bucket[3];
        int cyc = 0;
        for (int i = 0; i < 3; i++) {
            list[i] = new Bucket(io.nextInt(), io.nextInt());
        }
        for (int i = 0; i < 100; i++) {
            cyc = i % 3;
            if (cyc == 0) {
                if (list[0].fill + list[1].fill > list[1].cap) {
                    list[0].fill = list[0].fill + list[1].fill - list[1].cap;
                    list[1].fill = list[1].cap;
                } else {
                    list[1].fill += list[0].fill;
                    list[0].fill = 0;
                }
            }
            if (cyc == 1) {
                if (list[1].fill + list[2].fill > list[2].cap) {
                    list[1].fill = list[1].fill + list[2].fill - list[2].cap;
                    list[2].fill = list[2].cap;
                } else {
                    list[2].fill += list[1].fill;
                    list[1].fill = 0;
                }
            }
            if (cyc == 2) {
                if (list[2].fill + list[0].fill > list[0].cap) {
                    list[2].fill = list[2].fill + list[0].fill - list[0].cap;
                    list[0].fill = list[0].cap;
                } else {
                    list[0].fill += list[2].fill;
                    list[2].fill = 0;
                }
            }
        }
        for (int i = 0; i < 3; i++) {
            io.println(list[i].fill);
        }
        io.close();
    }
    static class Bucket {
        int cap; int fill;
        public Bucket(int cap, int fill) {
            this.cap = cap;
            this.fill = fill;
        }
    }
}
class Kattio extends PrintWriter {
    private BufferedReader r; private StringTokenizer st;
    public Kattio (String problemName) throws IOException {
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