import java.util.Scanner;

/**
 * Created by YSingh on 26/03/17.
 */
public class Fibonacci {
    public static int fibonacci(int n) {
        int [] arr = new int[40];
        arr[1] = 1;
        arr[2] = 1;

        for (int i = 3; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }

        return arr[n];
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
        System.out.println(fibonacci(n));
    }
}
