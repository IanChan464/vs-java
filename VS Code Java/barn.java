import java.util.*;
  import java.io.*;
  
  public class barn {
    static Scanner in;
    static ArrayList<Integer> adj[];
    static boolean[] visited;
    static int vc, e;
    public static void main(String[] args) throws Exception {
      in = new Scanner(System.in);
      int t = in.nextInt();
      for (int j = 0; j < t; j++) {

        vc = in.nextInt();
        e = in.nextInt();

        adj = new ArrayList[vc + 1];
        visited = new boolean[vc + 1];

        for (int i = 1; i <= vc; i++) adj[i] = new ArrayList<>();

        for (int i = 0; i < e; i++) {
          int a = in.nextInt();
          int b = in.nextInt();
          adj[a].add(b);
          adj[b].add(a);
        }
        System.out.println(dfs(1, 0));
      }
    }
    static int dfs(int u, int count) {
        if (u == vc) return 0;
      int min = Integer.MAX_VALUE/2;
      for (int v = 1; v <= vc; v++) {
        if (!visited[v]) { 
            if (!adj[u].contains(v) && count < 2) { min = Math.min(min, dfs(v, count+1) + (u-v)*(u-v)); } else if (count < 2) {
                visited[v] = true;
                min = Math.min(min, dfs(v, count));
            }
         }
      }
      return min;
    }
  }
   