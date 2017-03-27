import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by YSingh on 26/03/17.
 */
public class Challenge3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String [] arr = sc.nextLine().split(" ");
        int [] a = new int[arr.length];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            a[i] = Integer.parseInt(arr[i]);
        }

        int prev = a[0];
        list.add(a[0]);
        int ESCAPE_TOKEN = -128;
        int diff = 0;
        for (int i = 1; i < a.length; i++) {
            diff = a[i] - prev;
            if (Math.abs(diff) > 127) {
                list.add(ESCAPE_TOKEN);
            }
            list.add(diff);
            prev = a[i];
        }

        StringBuilder sb = new StringBuilder();

        for (Integer i : list) {
            sb.append(i);
            sb.append(" ");
        }

        System.out.println(sb.toString());
    }
}
