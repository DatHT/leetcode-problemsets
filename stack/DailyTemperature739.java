// https://leetcode.com/problems/daily-temperatures/
package stack;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperature739 {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        Arrays.fill(result, 0);
        Stack<Integer> stack = new Stack<>();

        for (int i =0; i < n; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int pos = stack.pop();
                result[pos] = i - pos;
            }
            stack.push(i);
        }

        return result;
    }
}
