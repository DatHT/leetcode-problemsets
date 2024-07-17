package TwoPointer;

import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/compare-version-numbers/description/
public class CompareVersionNumber165 {
    public int compareVersion(String version1, String version2) {
        List<String> list1 = Arrays.stream(version1.split("\\.")).toList();
        List<String> list2 = Arrays.stream(version2.split("\\.")).toList();

        int maxLength = Math.max(list1.size(), list2.size());

        for (int i = 0; i < maxLength; i++) {
            int firstNum = i < list1.size() ? Integer.parseInt(list1.get(i)) : 0;
            int secondNum = i < list2.size() ? Integer.parseInt(list2.get(i)) : 0;
            if (firstNum < secondNum) {
                return -1;
            } else if (firstNum > secondNum) {
                return 1;
            }
        }
        return 0;
    }
}
