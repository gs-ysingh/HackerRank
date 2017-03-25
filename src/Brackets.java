import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by YSingh on 25/03/17.
 */
public class Brackets {
    public static boolean isBalanced(String expression) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');
        for (int i = 0; i < expression.length(); i++) {
            if(expression.charAt(i) == '{'
                    || expression.charAt(i) == '('
                    || expression.charAt(i) == '[') {
                stack.push(expression.charAt(i));
            }

            if(expression.charAt(i) == '}'
                    || expression.charAt(i) == ')'
                    || expression.charAt(i) == ']') {
                if(!stack.isEmpty()
                        && map.get(stack.peek()) == expression.charAt(i)) {
                    stack.pop();
                }
                else {
                    return false;
                }
            }
        }

        if(stack.isEmpty()) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            String expression = in.next();
            System.out.println( (isBalanced(expression)) ? "YES" : "NO" );
        }
    }
}
