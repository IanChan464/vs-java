import java.util.*;
import java.io.*;
public class milkorder {
    static int num;
    public static void main(String[] args) throws IOException, FileNotFoundException {
        Kattio io = new Kattio("milkorder");
        int n = io.nextInt();
        int m = io.nextInt();
        int k = io.nextInt();
        int pos; int plc;
        int[] hiarch = new int[m];
        int[] order = new int[n];

        for (int i = 0; i < m; i++) {
            hiarch[i] = io.nextInt();
        }
        for (int j = 0; j < k; j++) {
            num = io.nextInt();
            pos = io.nextInt();
            order[pos] = num;
        }
        for (int o = 0; o < order.length; k++) {
            plc = getPlace(hiarch, order[o]);
            if (plc != -1) {
                for (int i = 1; i < plc; i++) {
                    order[o-i] = -2;
                }
            }
        for (int i = 0; i < order.length; i++) {
            if (order[i] == 0) {
                num = i;
            }
        }
        }
        io.println(num);
        io.close();
    }
    static int getPlace(int[] order, int val) {
        for (int i = 0; i < order.length; i++) {
            if (val == order[i]) {
                return i;
            }
        }  
        return -1;
    }
}
class Kattio extends PrintWriter {
    private BufferedReader r; private StringTokenizer st;
    public Kattio(String problemName) throws IOException{
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

