import java.util.*;
import java.io.*;

// USACO 2020 US Open Contest, Silver: Cereal
// https://usaco.org/index.php?page=viewproblem2&cpid=1039

public class cereal{
    static Scanner in;
    static int list1[];
    static int list2[];
    static PrintWriter out;
    public static void main(String[] args) throws Exception {
        in = new Scanner(new File("cereal.in"));
        out = new PrintWriter("cereal.out");
        
        int n = in.nextInt();
        int m = in.nextInt();

        list1 = new int[n];
        list2 = new int[n];

        for (int i = 0; i < n; i++) {
            list1[i] = in.nextInt();
            list2[i] = in.nextInt();
        }

        boolean[] boxes = new boolean[m+1];
        
        go(false, 0, boxes);
        out.close();
        
    }
    
    static int go(boolean start, int index, boolean[] boxes) {
        if (index == list1.length) { return 0; } 
        
        if (!boxes[list1[index]]) { boxes[list1[index]] = true; out.println( go(true, (index + 1), boxes) + 1); } else if (!boxes[list2[index]]) { boxes[list2[index]] = true; out.println(go(true, index + 1, boxes) + 1);} else {
            out.println(go(true, index + 1, boxes));
        }

        if (!start) {
            out.println(go(false, index + 1, boxes));
        }

        return 0;

    }
}