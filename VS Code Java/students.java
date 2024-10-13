import java.util.*; import java.io.*;
public class students {

  static ArrayList<Integer> adj[];
  static boolean[] visited;
  static int n, e;
  static long quality = 0;
  static int index = 0;
  static ArrayList<ArrayList<Integer>> groups;
  static int group;
  static long val = 1;
  public static void main(String[] args) throws Exception {
    System.out.println();
    System.out.println("Copy the url into your browser to view your graph!");
    
    Scanner in = new Scanner(new File("students.in"));
    PrintWriter out = new PrintWriter("students.out");

    int a, b;
    groups = new ArrayList<ArrayList<Integer>>();

    n = in.nextInt();
    e = in.nextInt();

    adj = new ArrayList[n + 1];
    visited = new boolean[n];
    Student[] roster = new Student[n];
    int[] pos = new int[n];

    for (int i = 0; i < n; i++) {
      adj[i + 1] = new ArrayList<>();
      roster[i] = new Student(in.next(), in.nextInt());
    }

    for (int i = 0; i < e; i++) {
      a = in.nextInt();
      b = in.nextInt();
      adj[a].add(b);
      adj[b].add(a);
    }

    Arrays.sort(roster, Collections.reverseOrder());

    for (int i = 0; i < n; i++) {
      out.println();
      for (int j = 0; j < adj[i + 1].size(); j++) {
        out.print(adj[i + 1].get(j) + " ");
      }
    }

    for (int i = 0; i < n; i++) {
        if (!visited[i]) {
            group = groups.size();
            groups.add(new ArrayList<>());
            dfs(i);
        }
    }
    out.println();
    Collections.sort(groups, (x, y) -> y.size() - x.size());
    for (int i = 0; i < groups.size(); i++) {
      for (int j = 0; j < groups.get(i).size(); j++) {
          out.println(roster[index].name + " " + groups.get(i).get(j));
          pos[index] = groups.get(i).get(j);
          val *= roster[roster.length-1-index].behaviour;
          index++;
      }
      out.println("Value of Group " + (i+1) + ": " + val);
      out.println(index);
      out.println();
      quality += val;
      val = 1;
    }
    out.println(Arrays.toString(pos));
    for (int i = 0; i < roster.length; i++) {
      out.print("(" + roster[i].name + "," + roster[i].behaviour + ")");
    }
    out.println();
    for (int i = 1; i < adj.length; i++) {
      out.print(adj[i].toString() + ", ");
    }
    System.out.println("chart.googleapis.com/chart?cht=gv&chl=graph{");
    for (int i = 0; i < 1; i++) {
      for (int j = 0; j < adj[i+1].size(); j++) {
        System.out.print(roster[i].name + pos[i] + "--" + roster[adj[i+1].get(j)-1].name + pos[adj[i+1].get(j)-1]);
        adj[adj[i+1].get(j)].remove(Integer.valueOf(i+1));
      }
    }
    for (int i = 1; i < n; i++) {
      for (int j = 0; j < adj[i+1].size(); j++) {
        System.out.print(";" + roster[i].name + pos[i] + "--" + roster[adj[i+1].get(j)-1].name + pos[adj[i+1].get(j)-1]);
        adj[adj[i+1].get(j)].remove(Integer.valueOf(i+1));
      }
    }
    System.out.print("}");
    System.out.println();
    System.out.println();
    
    out.println("Quality: " + quality);
    out.close();
  }
  
  static void dfs(int u) {
    if (visited[u]) { return; }
    groups.get(group).add(u+1);
    visited[u] = true;
    for (int v : adj[u+1]) {
      if (!visited[v-1]) { dfs(v); }
    }
  }
  static class Student implements Comparable<Student> {
    String name; int behaviour;
    public Student(String name, int behaviour) {
      this.name = name; 
      this.behaviour = behaviour;
    }
    public int compareTo(Student y) { return Integer.compare(behaviour, y.behaviour); }
  }
}