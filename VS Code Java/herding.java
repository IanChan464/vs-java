import java.util.*;
import java.io.*;
public class herding {
    public static void main(String[] args) throws IOException, FileNotFoundException {
        Kattio io = new Kattio("herding");
        int[] line = new int[3];
        line[0] = io.nextInt();
        line[1] = io.nextInt();
        line[2] = io.nextInt();
        Arrays.sort(line);
        io.println(least(line[0],line[1],line[2],0));
        io.println(great(line[0],line[1],line[2],0));
        io.close();
    }
    static int least(int x, int y, int z, int count) {
        int a = y - x;
        int b = z - y;
        if (a == 1 && b == 1) {
            return count;
        }
        count++;
        if (a == 2) {
            return least(x,y-1,y,count);
        } else if (b == 2) {
            return least(y,z-1,z,count);
        }
        if (a >= b) {
            return least(x,x+2,y,count);
        } else if (b > a) {
            return least(y,y+2,z,count);
        }
        return -1;
    }
    static int great(int x, int y, int z, int count) {
        int a = y - x;
        int b = z - y;
        if (a == 1 && b == 1) {
            return count;
        }
        count++;
        if (a >= b) {
            return great(x,y-1,y,count);
        }
        if (b > a) {
            return great(y,y+1,z,count);
        }
        return -1;
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