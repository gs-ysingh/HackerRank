import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by YSingh on 07/05/17.
 */
public class SpringBoard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String [] line = sc.nextLine().split(" ");

        int N = Integer.parseInt(str.split(" ")[0]);
        int X = Integer.parseInt(str.split(" ")[1]);

        int [] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(line[i]);
        }

        System.out.println(isPossible(N, X, arr) == true ? "YES" : "NO");

    }

    private static Boolean isPossible(int n, int x, int[] arr) {
        Arrays.sort(arr);
        Boolean [] M = new Boolean[x + 1];

        for (int i = 1; i <= x; i++) {
            M[i] = false;
            for (int j = 0; j < n; j++) {
                if(i == arr[j] && M[i] == false) {
                    M[i] = true;
                }
                else if(i > arr[j] && M[i] == false) {
                    M[i] = M[i - arr[j]];
                }
            }
        }

        return M[x];
    }
}
