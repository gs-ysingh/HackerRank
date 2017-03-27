import java.util.Scanner;

/**
 * Created by YSingh on 26/03/17.
 */
public class Challenge4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = Integer.parseInt(sc.nextLine());
        int n = Integer.parseInt(sc.nextLine());
        int [] start = new int[n];
        int [] end = new int[n];
        int i = 0;
        while (n > 0) {
            String x = sc.nextLine();
            int p = Integer.parseInt(x.split(" ")[0]);
            int q = Integer.parseInt(x.split(" ")[1]);
            start[i] = p;
            end[i] = q;
            i++;
            n--;
        }

        int count = 0;
        for (int j = 0; j < n - 1; j++) {
            for (int k = j + 1; k < n; k++) {

            }

        }

    }
}
