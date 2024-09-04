
import java.util.Arrays;
import java.util.Random;
import static java.lang.Math.max;

public class App {
    private static long iterations = 0;

    public static void main(String[] args) {
        int[] testValues = {4, 8, 16, 32, 128, 1000, 10000};
        for (int n : testValues) {
            iterations = 0;
            long startTime = System.currentTimeMillis();
            long result = fibo(n);
            long endTime = System.currentTimeMillis();
            System.out.println("FIBO(" + n + ") = " + result + ", Iterations: " + iterations + ", Time: " + (endTime - startTime) + " ms");
        }
    }
}

    public class FibonacciIterative {

    public static long fibo(int n) {
        if (n <= 1) {
            return n;
        }
        long[] f = new long[n + 1];
        f[0] = 0;
        f[1] = 1;
        for (int i = 2; i <= n; i++) {
            iterations++;
            f[i] = f[i - 1] + f[i - 2];
        }
        return f[n];
    }



}