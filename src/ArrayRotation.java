import java.util.Scanner;

/**
 * Created by YSingh on 20/03/17.
 */
public class ArrayRotation {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        int n = Integer.parseInt(line.split(" ")[0]) ;
        int d = Integer.parseInt(line.split(" ")[1]) ;

        String [] input = in.nextLine().split(" ");
        int [] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        printRotation(arr, n, d);
        //jugglingRotation(arr, n, d);
    }

    private static void printRotation(int[] arr, int n, int d) {
        int [] temp = new int[d];
        for (int i = 0; i < d; i++) {
            temp[i] = arr[i];
        }

        int j = 0;
        for (int i = d; i < n; i++) {
            arr[j++] = arr[i];
        }

        j = 0;
        for (int i = n - d; i < n; i++) {
            arr[i] = temp[j++];
        }

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
