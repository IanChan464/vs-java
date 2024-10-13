import java.util.*; import java.io.*;
public class sequence {
    static Scanner in;
    public static void main(String[] args) throws Exception {
        in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int c; int d;
        System.out.print(a + " " + b + " ");
        c = a;
        d = b;
        for (int i = 0; i < 3; i++) {
            
            System.out.print((c+d)+ " ");
            c  += d;

            
            System.out.print((c+d)+ " ");
            d += c;

        }
    }
}
