import java.util.HashMap;

/**
 * Created by YSingh on 30/04/17.
 */
public class MinDifferenceAnagram {
    public static void main(String[] args) {
        String [] a = {"tea"};
        String [] b = {"toe"};

        int [] res = getMinimumDifference(a, b);

        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }

    static int[] getMinimumDifference(String[] a, String[] b) {
        int len = a.length;
        int [] res = new int[len];

        String str1;
        String str2;

        for (int i = 0; i < len; i++) {
            str1 = a[i];
            str2 = b[i];
            if(str1.length() != str2.length()) {
                res[i] = -1;
            }
            else {
                res[i] = makeAnagram(str1, str2);
            }

        }
        return res;
    }

    private static int makeAnagram(String str1, String str2) {
        char[] A = str1.toCharArray();
        char[] B = str2.toCharArray();

        int[] diffs = new int['z' - 'a' + 1];

        for(char c : A){
            diffs[c - 'a']++;
        }

        for(char c : B){
            diffs[c - 'a']--;
        }

        int sum = 0;

        for(int diff : diffs) {
            sum += (diff < 0) ? - diff : diff;
        }

        return sum / 2;
    }

}
