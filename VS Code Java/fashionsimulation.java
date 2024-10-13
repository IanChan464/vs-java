import java.util.*; import java.io.*;
public class fashionsimulation {
    static Scanner in; static int n; 
    public static void main(String[] args) throws Exception {
        in = new Scanner(System.in);
        TreeSet<fraction> set = new TreeSet<>((a,b) -> (b.top/b.bot - a.top/a.bot));
        boolean lever = false;
        set.add(new fraction(1,1));
        set.add(new fraction(1,2));
        set.add(new fraction(2,3));
        set.add(new fraction(6,7));
        while (true) {

            n = in.nextInt();
            if (n == 0) {
                System.exit(0);
            } else {
                for (int i = 0; i < n; i++) {
                    fraction[] read = set.toArray();
                    if (lever) {
                        set.add(new fraction((read[0].bot)*(read[1].bot), (read[0].top*read[1].bot) + (read[0].bot*read[1].top)));
                    } else {
                        set.add(new fraction((read[read.length-1].bot)*(read[read.length-2].bot), (read[read.length-1].top*read[read.length-2].bot) + (read[read.length-1].bot*read[read.length-2].top)));
                        lever = true;
                    }
                    for (int j = 0; j < read.length; j++) {
                        System.out.print(read[j].top + "/" + read[j].bot + ";");
                    }
                    System.out.println();
                }  
            }
        }
            
    }
    static class fraction {
        int top, bot;
        public fraction(int top, int bot) {
            this.top = top;
            this.bot = bot;
        }
    }
}

