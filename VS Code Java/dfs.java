import java.util.*;
  import java.io.*;
  
  public class dfs {
    static Scanner in;
    static ArrayList<Integer> adj[];
    static boolean[] visited;
    static int v, e;
    public static void main(String[] args) throws Exception {
      in = new Scanner(System.in);
      int t = in.nextInt();
      for (int j = 0; j < t; j++) {
        v = in.nextInt();
        e = in.nextInt();
        adj = new ArrayList[v + 1];
        visited = new boolean[v + 1];
        for (int i = 1; i <= v; i++) adj[i] = new ArrayList<>();

        for (int i = 0; i < e; i++) {
          int a = in.nextInt();
          int b = in.nextInt();
          adj[a].add(b);
          adj[b].add(a);
        }
        dfs(1);
      }
    }
    static void dfs(int u) {
      visited[u] = true;
      for (int v : adj[u]) {
        if (!visited[v]) { dfs(v); }
      }
    }
  }
  