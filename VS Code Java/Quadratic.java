import java.util.*;
public class Quadratic {
    static void Root(float power2, float power, float constant) {
        System.out.println("The roots are: " + ((-power + Math.pow((power*power) - 4*power2*constant, .5))/(2*power2)) + " and " + ((-power - Math.pow((power*power) - 4*power2*constant, .5))/(2*power2)));
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Welcome to Quadratic Root Calculator! Please insert the a value of your quadratic, assuming the format is ax{^2} + bx + c");
        float m = in.nextFloat();
        System.out.println("Next, enter the b value");
        float n = in.nextFloat();
        System.out.println("Finally, enter the c value");
        float o = in.nextFloat();
        Quadratic.Root(m,n,o);
    }
}