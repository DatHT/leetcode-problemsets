// https://leetcode.com/problems/valid-triangle-number/description/

package TwoPointer;

import java.util.Arrays;

public class ValidTriangleNumber611 {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        for (int i = nums.length - 1; i >= 1 ; i --) {
            int left = 0;
            int right = i - 1;
            while (left < right) {
                if (nums[left] + nums[right] > nums[i]) {
                    count += right - left;
                    right--;
                } else {
                    left ++;
                }
            }
        }
        return count;
    }
}
