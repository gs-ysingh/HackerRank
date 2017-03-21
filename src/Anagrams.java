import java.util.Scanner;

/**
 * Created by YSingh on 21/03/17.
 */
public class Anagrams {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line1 = sc.nextLine();
        String line2 = sc.nextLine();

        System.out.println(getDiffAnagrams(line1, line2));
    }

    private static int getDiffAnagrams(String line1, String line2) {
        int size = 26;
        int [] a = new int[size];
        int [] b = new int[size];
        int value = 0;
        for (int i = 0; i < line1.length(); i++) {
            value = (int)(line1.charAt(i));
            a[value - 97] = a[value - 97] + 1;
        }

        for (int i = 0; i < line2.length(); i++) {
            value = (int)(line2.charAt(i));
            b[value - 97] = b[value - 97] + 1;
        }

        int diff = 0;
        for (int i = 0; i < size; i++) {
            diff += (a[i] > b[i] ? a[i] - b[i] : b[i] - a[i]);
        }

        return diff;
    }
}
