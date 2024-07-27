package stack;

import java.util.Stack;

public class DecodeString394 {

    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        StringBuilder numBuilder = new StringBuilder();
        StringBuilder strBuilder = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                numBuilder.append(c);
            } else if (Character.isLetter(c)) {
                strBuilder.append(c);
            } else if (c == '[') {
                stack.push(strBuilder.toString());
                stack.push(numBuilder.toString());
                numBuilder = new StringBuilder();
                strBuilder = new StringBuilder();
            } else { // c == ']'
                int repeatTimes = Integer.parseInt(stack.pop());
                String prevStr = stack.pop();
                for (int i = 0; i < repeatTimes; i++) {
                    prevStr += strBuilder.toString();
                }
                strBuilder = new StringBuilder(prevStr);
            }
        }

        return strBuilder.toString();
    }
    public String decodeString1(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder builderBucket = new StringBuilder();
        StringBuilder builderNumber = new StringBuilder();
        StringBuilder builderResult = new StringBuilder();
        int count = 0;
        for (int i = 0; i < s.length(); i ++) {
            char c = s.charAt(i);
            if (c != ']') {
                if (c == '[') count ++;
                stack.push(c);
            } else {
                // pop until find the [
                char top = stack.pop();
                while (top != '[') {
                    builderBucket.append(top);
                    top = stack.pop();
                }
                count--;

                top = stack.pop();
                while (Character.isDigit(top)) {
                    builderNumber.append(top);
                    if (!stack.isEmpty())
                        top = stack.pop();
                    else break;
                }
                stack.push(top);
                String bucket = builderBucket.reverse().toString();
                builderBucket.append(bucket.repeat(Math.max(0, Integer.parseInt(builderNumber.toString()) - 1)));
                if (count == 0) {
                    builderResult.append(builderBucket);
                    builderBucket.setLength(0);
                }
                builderNumber.setLength(0);
            }
        }
        return builderResult.toString();
    }
}
