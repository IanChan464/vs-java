
import java.io.PrintWriter;
import java.util.*;
public class TripleX {
    static void Triple(long num) {
        System.out.println(num);
        if (num == 1) {
            System.out.println("False");
            System.exit(0);
        }
        if (num % 2 == 0) {
            Triple(num/2);
        } else {
        Triple((3*num)+1);
        }   
    }
    public static void main(String[] args) {
       Scanner in = new Scanner(System.in);  
       long k = in.nextLong();
       TripleX.Triple(k);
    }
}