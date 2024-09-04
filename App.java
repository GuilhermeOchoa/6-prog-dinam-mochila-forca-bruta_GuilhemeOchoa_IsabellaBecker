
import java.util.Arrays;
import java.util.Random;
import static java.lang.Math.max;

public class App {
    private static long iterations = 0;

    public static void main(String[] args) {
        int[] sizes = {32, 2048, 1048576};

        for (int size : sizes) {
            

            long startTime = System.currentTimeMillis();
            iterations = 0;
            pow(2,3);
            //maxValue1(array);
           // maxValue2(array,0,array.length-1);
            long endTime = System.currentTimeMillis();
            System.out.println("Size: " + size + ", Iterations mergeSort: " + iterations + ", Time: " + (endTime - startTime) + " ms");
        }
       

    }

    public static long pow(int a, int n) {
        if (n == 0) {
            iterations++;
            return 1;
        } else {
            long x = pow(a, n / 2);
            if (n % 2 == 0) {
                iterations++;
                return x * x;
            } else {
                iterations++;
                return a * x * x;
            }
        }
    }

}