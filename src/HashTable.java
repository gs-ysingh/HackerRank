import java.util.HashMap;
import java.util.Hashtable;
import java.util.Scanner;

/**
 * Created by YSingh on 25/03/17.
 */
public class HashTable {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        String magazine[] = new String[m];
        for(int magazine_i = 0; magazine_i < m; magazine_i++){
            magazine[magazine_i] = in.next();
        }
        String ransom[] = new String[n];
        for(int ransom_i=0; ransom_i < n; ransom_i++){
            ransom[ransom_i] = in.next();
        }

        System.out.println(unTraceable(magazine, ransom, m, n));
    }

    private static String unTraceable(String[] magazine, String[] ransom, int m, int n) {
        HashMap<String, Integer> map = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();

        for (int i = 0; i < magazine.length; i++) {
            if(map.get(magazine[i]) == null) {
                map.put(magazine[i], 1);
            }
            else {
                map.put(magazine[i], map.get(magazine[i]) + 1);
            }
        }
        for (int i = 0; i < ransom.length; i++) {
            if(map2.get(ransom[i]) == null) {
                map2.put(ransom[i], 1);
            }
            else {
                map2.put(ransom[i], map2.get(ransom[i]) + 1);
            }
        }
        for(String key : map2.keySet()) {
            if(map2.get(key) > map.get(key) || map.get(key) == null) {
                return "No";
            }
        }
        return "Yes";
    }
}
