import java.util.*; import java.io.*;
public class interview {

    static Scanner in;
    static boolean[] visited;
    static int[] times;
    static int mintime = Integer.MAX_VALUE;
    static int index = 0;
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    public static void main(String[] args) throws Exception {

        in = new Scanner(System.in);

        int n = in.nextInt();
        int k = in.nextInt();
        index += k;

        visited = new boolean[k+1];
        times = new int[n];
        LinkedList<Integer> order = new LinkedList<>();;

        for (int i = 0; i < n; i++) {
            times[i] = in.nextInt();
        }
        for (int i = 0; i < k; i++) {
            order.add(i+1);
            pq.add(times[i]);
            for (int it : pq) {
                
            }
        }
        go(order, 0);
        System.out.println(mintime);
        for (int i = 1; i < n + 1; i++) {
            if (visited[i]) { System.out.print("1"); } else { System.out.print("0"); }
        }
    }
    static void go(LinkedList<Integer> order, int time) {
        int cur = pq.poll();
        time += cur;
        if (pq.size() == 0) {
            visited[order.peek()] = true;
            mintime = Math.min(time, mintime);
        }
        for (int it : pq) {
            it.getAndDecrement();
        }
        pq.add(times[index]);
        index++;
        if (pq.peek() == 0) {
            int a = order.pollFirst();
            int b = order.pollFirst();
            order.addLast(a);
            order.addLast(b);
            go(order, time);
            order.removeLast();
            order.removeLast();
            order.add(b);
            order.add(a);
            go(order, time);
        } else {
            int a = order.pollFirst();
            order.addLast(a);
            go(order, time);
        }
    }
}