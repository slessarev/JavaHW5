import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class task1 {
    private static Map<Character, Character> bracketsMap = new HashMap<>();

    static {
        bracketsMap.put('(', ')');
        bracketsMap.put('[', ']');
        bracketsMap.put('{', '}');
        bracketsMap.put('<', '>');
    }

    public static boolean isCorrectParentheses(String sequence) {
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < sequence.length(); i++) {
            char c = sequence.charAt(i);
            if (bracketsMap.containsKey(c)) {
                stack.push(c);
            } else if (bracketsMap.containsValue(c)) {
                if (stack.isEmpty() || bracketsMap.get(stack.pop()) != c) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String sequence1 = "()[]{}";
        String sequence2 = "([{}])";
        String sequence3 = "([)]";
        String sequence4 = "((()";
        String sequence5 = "(><[{}])";
        String sequence6 = "(<[{}]>)";
        System.out.println(isCorrectParentheses(sequence1)); // true
        System.out.println(isCorrectParentheses(sequence2)); // true
        System.out.println(isCorrectParentheses(sequence3)); // false
        System.out.println(isCorrectParentheses(sequence4)); // false
        System.out.println(isCorrectParentheses(sequence5)); // false
        System.out.println(isCorrectParentheses(sequence6)); // true
    }
}
