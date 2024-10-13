import java.util.*;
import java.io.*;
public class std3 {
    public static void main(String[] args) throws IOException, FileNotFoundException {
        Kattio io = new Kattio();
        int n = io.nextInt();
        int k = 0; int z = 0;
        ArrayList<Integer> height = new ArrayList<>();
        ArrayList<Integer> rate = new ArrayList<>();
        ArrayList<Integer> goal = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            height.clear();
            rate.clear();
            goal.clear();
            k = io.nextInt();
            for (int j = 0; j < k; j++) {
                height.add(io.nextInt());
            }
            for (int l = 0; l < k; l++) {
                rate.add(io.nextInt());
            }
            for (int o = 0; o < k; o++) {
                goal.add(io.nextInt());
            }
            z = (go(createPlantArr(k, goal, rate, goal),0));
            io.println(z);
        }
        io.close();
    }
    static Plant[] createPlantArr(int k, ArrayList<Integer> a, ArrayList<Integer> b, ArrayList<Integer> c) {
        Plant[] plants = new Plant[k];
        for (int m = 0; m < k; m++) {
            plants[m] = new Plant(a.get(m), b.get(m), c.get(m));
        }
        Arrays.sort(plants);
        return plants;
    }
    static int go(Plant[] plants, int day) {
        if (day >= 10) {
            return -1;
        }
        if (checkGood(plants) == true) {
            return day;
        }
        for (int i = 0; i < plants.length; i++) {
            plants[i].height += plants[i].rate;
        }
        Arrays.sort(plants);
        return go(plants, day+1);
    }
    static boolean checkGood(Plant[] plants) {
        for (int i = 0; i < plants.length; i++) {
            if (plants[i].goal != i) {
                return false;
            }
        }
        return true;
    }
static class Plant implements Comparable<Plant> {
    int rate, height, goal;
    public Plant(int rate, int height, int goal) {
        this.rate = rate;
        this.height = height;
        this.goal = goal;
    }
    public int compareTo(Plant y) { return Integer.compare(height, y.height); }
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