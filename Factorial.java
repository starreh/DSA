import java.util.*;

public class Factorial {

    private static int factorial(int n) {
        if (n == 0) return 1;
        if (n == 1) return 1;

        return n * factorial(n-1);
    }

    public static void main (String[] args) {
        int n = 5;

        int factorial = factorial(n);
        System.out.println(factorial);
    }
}
