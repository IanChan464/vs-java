
  import java.util.*;
  import java.io.*;
  
  public class Main {
    static Scanner in;
    static boolean pass;
    static int[][] graph;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int n;
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
      in = new Scanner(System.in);
      int t = in.nextInt();
      for (int i = 0; i < t; i++) {
        n = in.nextInt();
        visited = new boolean[n+2][n+2];
        pass = false;
        graph = new int[n+2][n+2];
        for (int j = 1; j < n; j++) {
            for (int k = 1; k < n; k++) {
                if (in.next() == "-") {
                    graph[j][k] = 1;
                }
            }
        }
        dfs(1,1);
        if (pass) {System.out.println("Solveable"); } else { System.out.println("Unsolveable"); }
      }
    }
    static void dfs(int r, int c) {
        if (r == graph.length - 3 && c == graph.length - 3) {
            pass = true;
        }
        if (!visited[r+1][c+1] && graph[r+1][c+1] == 1) {
            visited[r][c] = true;
            for (int i = 0; i < 4; i++) {
                int rr = r + dy[i];
                int cc = r + dx[i];
                dfs(rr, cc);
            }
        } else { return; }
    }
  }
  