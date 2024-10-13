      import java.io.*;
      import java.util.*;
      
      public class tubes {
      
        static Scanner in;
        static char[] t1; static char[] t2; static char[] t3;

        public static void main(String[] args) throws Exception {
          in = new Scanner(System.in);
          int t = in.nextInt(); int n; char current; int count; int p;
          for (int j = 0; j < t; j++) {
            n = in.nextInt();
            p = in.nextInt();
            t1 = in.next().toCharArray();
            t2 = in.next().toCharArray();
            
            current = t1[0];
            count = 0;
            for (int i = 1; i < n; i++) {
               if ((current + "").compareTo((t1[i]) + "") != 0) {
                current = t1[i];
               } else {
                count++;
               }
            }
            current = t2[0];
            for (int i = 1; i < n; i++) {
                if ((current + "").compareTo(t2[i] + "") != 0) {
                    current = t2[i];
                   } else {
                    count++;
                }
            }
            System.out.println(count);
          }
        }
      }