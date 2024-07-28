package stack;

import java.util.HashMap;
import java.util.Stack;

public class ValidParathenses20 {
    public boolean isValid(String s) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        Stack<Character> stack = new Stack<>();
        if (s.length() == 1) return false;
        for (int i = 0; i < s.length(); i ++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                if (!stack.isEmpty() && stack.peek() == map.get(c)) {
                    stack.pop();
                } else return false;
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        ValidParathenses20 v = new ValidParathenses20();
        System.out.println(v.isValid("()"));
        System.out.println(v.isValid("()[]{}"));
        System.out.println(v.isValid("(]"));
    }
}
