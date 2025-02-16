import java.util.*;

public class Fibonacci {

    private static int fibonacci (int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        return fibonacci(n-1) + fibonacci(n-2);
    }

    public static void main (String[] args) {
        int n = 5;

        for (int i = 0; i < n; i++) {
            System.out.println(fibonacci(i));
        }
    }
}