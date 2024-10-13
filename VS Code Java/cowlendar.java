      import java.io.*;
      import java.util.*;
      
      public class cowlendar {
      
        static Scanner in;
      
        public static void main(String[] args) throws Exception {
          TreeSet<Integer> ts = new TreeSet<>();
          HashSet<Integer> set = new HashSet<>();
          in = new Scanner(System.in);
          int n = in.nextInt();
          for (int i = 0; i < n; i++) {
            ts.add(in.nextInt());
          }
          int count = 0;
          Integer arr[] = new Integer[ts.size()];
          arr = ts.toArray(arr);
          for (int i = 1; i <= arr[0]/4; i++) {
            for (int j = 0; j < ts.size(); j++) {
              set.add(arr[j] % i);
            }
            if (set.size() < 4) {
              count += i;
            }
            set.clear();
          }
          System.out.println(count);
        }
      }