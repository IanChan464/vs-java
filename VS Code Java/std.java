import java.util.*; import java.io.*;
public class std {
    public static void main(String[] args) throws IOException, FileNotFoundException {
        Kattio io = new Kattio();
        int n = io.nextInt();
        int m = io.nextInt();
        long count = 0;
        long[] cows = new long[n];
        Cane[] canes = new Cane[m];
        for (int i = 0; i < n; i++) {
            cows[i] = io.nextLong();
        }
       for (int i = 0; i < m; i++) {
            canes[i] = new Cane(io.nextLong(), 0);
        }
       for (int j = 0; j < m; j++) {
            for (int i = 0; i < n; i++) {
		        if (canes[j].height == canes[j].dist) {
			        break;
		        }
                if (cows[i] > canes[j].dist) {
                    count += Math.min(cows[i], canes[j].height) - canes[j].dist;
                    canes[j].dist = Math.min(cows[i], canes[j].height);
                }
                cows[i] += count;
                count = 0;
            }
       }
        for (int i = 0; i < n; i++) {
            io.println(cows[i]);
       }
        io.close();
   }
static class Cane {
   long height, dist;
   public Cane(long height, long dist) {
       this.height = height;
       this.dist = dist;
   }
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
   public long nextLong() { return Long.parseLong(next()); }
}



