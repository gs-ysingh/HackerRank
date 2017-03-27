import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by YSingh on 26/03/17.
 */
public class Challenge {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Integer> map = new HashMap<>();
        map.put("r", 0);
        map.put("s", 0);
        map.put("o", 0);

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            try{
                int a = Integer.parseInt(line.split(" ")[0]);
                int b = Integer.parseInt(line.split(" ")[1]);
                int c = Integer.parseInt(line.split(" ")[2]);
                int d = Integer.parseInt(line.split(" ")[3]);
                setMap(a, b, c, d, map);
            }
            catch(NumberFormatException ex){
                map.put("o", map.get("o") + 1);
            }
        }

        System.out.print(map.get("r") + " " + map.get("s") + " " + map.get("o"));
    }

    private static void setMap(int a, int b, int c, int d, Map<String, Integer> map) {
        if(a < 0 || b < 0 || c < 0 || d < 0) {
            map.put("o", map.get("o") + 1);
        }
        else if(a == b && b == c && c == d) {
            map.put("s", map.get("s") + 1);
        }
        else if(a == c && b == d) {
            map.put("r", map.get("r") + 1);
        }
        else {
            map.put("o", map.get("o") + 1);
        }
    }
}
