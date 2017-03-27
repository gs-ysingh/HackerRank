import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by YSingh on 26/03/17.
 */
public class Challenge2 {
    private static int getCount(String str, String word) {
        String in = str;
        int i = 0;
        Pattern p = Pattern.compile(word);
        Matcher m = p.matcher( in );
        while (m.find()) {
            i++;
        }
        return i;
    }

    private static <K, V> Map<K, V> sortByValue(Map<K, V> map) {
        List<Map.Entry<K, V>> list = new LinkedList<>(map.entrySet());
        Collections.sort(list, new Comparator<Object>() {
            @SuppressWarnings("unchecked")
            public int compare(Object o1, Object o2) {
                return ((Comparable<V>) ((Map.Entry<K, V>) (o1)).getValue()).compareTo(((Map.Entry<K, V>) (o2)).getValue());
            }
        });

        Map<K, V> result = new LinkedHashMap<>();
        for (Iterator<Map.Entry<K, V>> it = list.iterator(); it.hasNext();) {
            Map.Entry<K, V> entry = (Map.Entry<K, V>) it.next();
            result.put(entry.getKey(), entry.getValue());
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String [] arr = sc.nextLine().split(" ");
        int n = Integer.parseInt(sc.nextLine());
        Map<Integer, Integer> map = new HashMap<>();
        while (n > 0) {
            int val = Integer.parseInt(sc.nextLine());
            String a = sc.nextLine();
            int count = 0;
            for (int i = 0; i < arr.length; i++) {
                count += getCount(a, arr[i]);
            }
            map.put(val, count);
            n--;
        }

        Map<Integer, Integer> res = sortByValue(map);

        Stack<Integer> stack = new Stack<>();
        for(Integer key : res.keySet()) {
            stack.push(key);
        }

        StringBuilder sb = new StringBuilder();

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
            sb.append(" ");
        }

        System.out.println(sb.toString());
    }
}
