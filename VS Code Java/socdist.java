import java.util.*;
  import java.io.*;
  
  public class socdist {
    static Scanner in;
    static PrintWriter out;
    public static void main(String[] args) throws Exception {
      in = new Scanner(new File("socdist.in"));
      out = new PrintWriter("socdist.out");
      int n = in.nextInt();
      int m = in.nextInt();
      ArrayList<Integer> dist = new ArrayList<>();
      ArrayList<Integer> set = new ArrayList<>();
      for (int i = 0; i < 2*m; i++) {
        set.add(in.nextInt());
      }
      for (int i = 0; i < set.size() - 1; i++) {
        dist.add(set.get(i+1) - set.get(i));
      }
      Collections.sort(dist);
      out.println(dist.get(2*m - n));
      out.close();
    }
  }
  