package stack;

import java.util.HashMap;
import java.util.Stack;

/**
 * 20. Valid Parentheses
 */
public class ValidParentheses {

    HashMap<Character, Character> hashMap = new HashMap<Character, Character>(3);
    Stack<Character> stringStack = new Stack<Character>();

    public boolean isValid(String s) {
        if (s.length() == 0) return true;
        hashMap.put(')', '(');
        hashMap.put(']', '[');
        hashMap.put('}', '{');
        for (int i = 0; i < s.length(); i++) {
            Character item = s.charAt(i);
            Character left;
            if ((left = hashMap.get(item)) == null) {
                stringStack.push(item);
            } else {
                if (stringStack.size() == 0) return false;
                if (left != stringStack.pop()) return false;
            }
        }
        if (stringStack.size() != 0) return false;
        return true;
    }

    public static void main(String[] args) {
        String input = "{[]}";
        System.out.println(new ValidParentheses().isValid(input));
    }
}
