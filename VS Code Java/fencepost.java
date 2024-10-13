import java.util.*; import java.io.*;
public class fencepost {

    static Scanner in;
    static int grid[][] = new int[100000000][100000000];
    static boolean visited[][] = new boolean[100000000][100000000];
    static boolean touch[][];

    public static void main(String[] args) throws Exception {


        in = new Scanner(System.in);
        int n = in.nextInt();
        int p = in.nextInt();
        int a, b;
        int x1, x2, y1, y2;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0 ,-1, 1};

        for (int i = 0; i < p; i++) {
            grid[in.nextInt()][in.nextInt()] = 1;
        }
        for (int i = 0; i < n; i++) {

            touch[][] = new touch[100000000][100000000];
            point cur = new point(in.nextInt(), in.nextInt());
            point end = new point(in.nextInt(), in.nextInt());
            if (!visited[cur.x][cur.y]) {
                Queue<point> queue = new LinkedList<point>();
                queue.add(new point(cur.x, cur.y));
                while (!queue.empty()) {
                    a = queue.peek().x;
                    b = queue.poll().y;
                    visited[a][b] = true;
                    for (int j = 0; j < 4; j++) {
                        if ((!visited[cur.x + dx[j]][cur.y + dy[j]] && (grid[cur.x + dx[j]][cur.y + dy[j]]) == 0)) {
                            queue.add(new point(cur.x + dx[j], cur.x + dy[j]));
                        } else {
                            if (grid[cur.x + dx[j]][cur.y + dy[j]] != 0 && touch[cur.x + dx[j]][cur.x + dy[j]]) {
                                touch[cur.x + dx[j]][cur.x + dy[j]] = false;
                                grid[cur.x + dxbh
                            }
                        }
                    }
                }
            } System.out.println("\\*this is not a co\n\\");
        }   
    }
    static class point {
        int x, y;
        public point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
}